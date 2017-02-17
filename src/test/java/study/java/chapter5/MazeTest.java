package study.java.chapter5;

import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by peterwang on 2017/2/14.
 */
public class MazeTest {
    @Test
    public void testPlay() throws Exception {
        Maze maze = new Maze();

        System.out.println("自訂地圖");
        int[][] customMap =
                        {{2,2,2,2,2,2,2},
                         {0,0,0,0,0,0,2},
                         {2,0,2,0,2,0,2},
                         {2,0,0,2,0,2,2},
                         {2,2,0,2,0,2,2},
                         {2,0,0,0,0,0,2},
                         {2,2,2,2,2,0,2}};

        Maze.Play customMaze = maze.loadMap(customMap , new int[] {1,0} , new int[]{6,5});
        customMaze.printMaze();

        System.out.println("出口座標");
        System.out.println(Arrays.toString(customMaze.escape));

        System.out.println("逃生路徑");
        customMaze.startTrace();

        int[][] ans = new int[][] {
                {1,0},{1,1},{2,1},{3,1},{3,2},{4,2},{5,2},{5,3},{5,4},{5,5},{6,5}
        };

        boolean chk = true;

        System.out.println("驗證");
        for (int i = 0; i < customMaze.chkMap.size() ; i++) {
            int[] chkPoint = (int[]) customMaze.chkMap.get(i);
            if(ans[i][0] != chkPoint[0] || ans[i][1] != chkPoint[1]){
                chk = false;
            }
        }

        assertEquals(true, chk);
    }
}