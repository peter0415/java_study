package study.java.chapter5;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by peterwang on 2017/2/9.
 */
public class Test {
    public static void main(String[] args) {

        int[][] maze = {{2,2,2,2,2,2,2},
                        {0,0,0,0,0,0,2},
                        {2,0,2,0,2,0,2},
                        {2,0,0,2,0,2,2},
                        {2,2,0,2,0,2,2},
                        {2,0,0,0,0,0,2},
                        {2,2,2,2,2,0,2}};


        trace("",1,0,maze);

    }


    public static  void trace( String road  ,int x ,int y ,int[][] maze) {


        road = road +"["+x+","+y+"]";
        //System.out.println(road);
        if ( x == 6 && y == 5 ){
            System.out.println(road);

            return ;
        }

        if ( x < 0 || x > 6 || y < 0 || y > 6 ){
            return ;
        }

        if ( maze[x][y] == 2 || maze[x][y] == -1 ){
            return ;
        }

        maze[x][y] = -1;

        trace(road,x,y+1,maze);
        trace(road,x,y-1,maze);
        trace(road,x+1,y,maze);
        trace(road,x-1,y,maze);


    }

}
