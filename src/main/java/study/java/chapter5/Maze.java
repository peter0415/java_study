package study.java.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by peterwang on 2017/2/14.
 */
public class Maze {


    public static void main(String[] args) {
        Maze maze = new Maze();
        System.out.println("迷宮地圖");
        Play randomMaze = maze.randomMap(5,5);
        randomMaze.printMaze();

        System.out.println("出口座標");
        System.out.println(Arrays.toString(randomMaze.escape));

        System.out.println("逃生路徑");
        randomMaze.startTrace();

    }

    public Play randomMap(int row, int column){

        int[][] map = new int[row][column];
        Random rand = new Random();


        for (int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                map[i][j] = 2;
                if(i > 0 && i < ( row - 1 ) ){
                    if( j > 0 && j < ( column - 1 )  ){
                        if( rand.nextInt(100) > 20 ){
                            map[i][j] = 0;
                        }
                    }
                }
            }
        }

        return this.loadMap(map);

    }

    public Play loadMap(int[][] map){
        return new Play(map);
    }

    public Play loadMap(int[][] map , int[] entrance  , int[] escape){
        return new Play(map , entrance  , escape);
    }


    public class Play {

        private int row;
        private int column;
        private int[][] map;
        public ArrayList chkMap;
        private int[] entrance;
        public int[] escape;

        public Play(int[][] map) {
            this.map = map;
            this.setRow(this.map.length);
            this.setColumn(this.map[0].length);

            // 入口座標
            this.entrance = new int[] {0,1};

            // 出口座標
            this.escape = new int[] { this.getRow() - 1 , getColumn() - 2 };

            // 開啟出入口
            this.map[this.entrance[0]][this.entrance[1]] = 0;
            this.map[this.entrance[0] + 1][this.entrance[1]] = 0;
            this.map[this.escape[0] - 1][this.escape[1]] = 0;
            this.map[this.escape[0]][this.escape[1]] = 0;

        }

        public Play(int[][] map , int[] entrance , int[] escape ) {
            this.map = map;
            this.setRow(this.map.length);
            this.setColumn(this.map[0].length);

            // 入口座標
            this.entrance = entrance;

            // 出口座標
            this.escape = escape;

        }


        public void startTrace(){
            ArrayList road = new ArrayList();
            this.trace(road,0, this.entrance[0], this.entrance[1], this.map);
        }

        private ArrayList trace(ArrayList road , int step , int r, int c ,int[][] map){

            if ( r < 0 || r > (getRow() - 1 ) || c < 0 || c > (this.getColumn() - 1 ) ){
                return road;
            }

            if ( map[r][c] == 2 || map[r][c] == 6 ){
                return road;
            }

            ArrayList point = new ArrayList();
            point.add(r);
            point.add(c);

            road.add(point);

            if ( r == this.escape[0] && c == this.escape[1] ){
                System.out.println("======");

                map[r][c]=6;

                this.chkMap = new ArrayList();
                for (int i = 0; i < map.length; i++) {
                    System.out.println(Arrays.toString(map[i]));
                    for (int j = 0; j < map[i].length; j++) {
                        if(map[i][j] == 6){
                            this.chkMap.add(new int[]{i,j});
                        }
                    }
                }


                map[r][c]=0;
                return road;
            }


            step++;
            ArrayList roadTmp;

            map[r][c] = 6;
            roadTmp = this.trace(road ,step, r ,c+1 , map); // 右
            if(this.twoRoadCheck(road,roadTmp)){
                map[r][c] = 0;
            }
            road = roadTmp;

            map[r][c] = 6;
            roadTmp = this.trace(road ,step,r+1 , c , map); // 下
            if(this.twoRoadCheck(road,roadTmp)){
                map[r][c] = 0;
            }
            road = roadTmp;

            /*
            map[r][c] = 6;
            roadTmp = this.trace(road ,step, r ,c-1 , map); // 左
            if(this.twoRoadCheck(road,roadTmp)){
                map[r][c] = 0;
            }

            map[r][c] = 6;
            roadTmp = this.trace(road ,step,r-1 , c , map); // 上
            if(this.twoRoadCheck(road,roadTmp)){
                map[r][c] = 0;
            }
            */
            return road;

        }

        public void printMaze(){
            for(int[] m : this.map){
                System.out.println(Arrays.toString(m));
            }
        }

        private boolean twoRoadCheck(ArrayList road1,ArrayList road2){
            for (int i = 0; i < road1.size() ; i++) {
                if(road1.get(i) != road2.get(i)){
                    return false;
                }
            }
            return true;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public void setEntrance(int r , int c){
            this.entrance = new int[]{r, c};
        }
    }
}
