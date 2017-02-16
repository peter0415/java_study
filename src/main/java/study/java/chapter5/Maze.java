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
        Run randomMaze = maze.randomMap(5,5);
        randomMaze.printMaze();

        System.out.println("出口座標");
        System.out.println(Arrays.toString(randomMaze.escape));

        System.out.println("逃生路徑");
        randomMaze.startTrace();

    }

    public Run randomMap(int row, int column){

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

    public Run loadMap(int[][] map){
        return new Run(map);
    }


    public class Run {

        private int row;
        private int column;
        private int[][] map;
        private int[] entrance = {0,1};
        private int[] escape;

        public Run(int[][] map) {
            this.map = map;
            this.setRow(map.length);
            this.setColumn(map[0].length);

            // 出口座標
            this.escape = new int[] { this.getRow() - 1 , getColumn() - 2 };

            // 開啟出入口
            this.map[this.entrance[0]][this.entrance[1]] = 0;
            this.map[this.entrance[0] + 1][this.entrance[1]] = 0;
            this.map[this.escape[0] - 1][this.escape[1]] = 0;
            this.map[this.escape[0]][this.escape[1]] = 0;
        }

        public void startTrace(){

            ArrayList road = new ArrayList();

            ArrayList traceRoad = this.trace(road,0, this.entrance[0], this.entrance[1], this.map);

            for (int i = 0; i < traceRoad.size() ; i++) {
                //System.out.println(road.get(i));
            }
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

                for(int[] m : map){
                    System.out.println(Arrays.toString(m));
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

            //road = this.trace(road ,step, r ,c-1 , map); // 左
            //road = this.trace(road ,step,r-1 , c , map); // 上

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
    }
}
