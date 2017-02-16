package study.java.chapter5;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by peterwang on 2017/2/15.
 */
public class QueenTest {
    @org.junit.Test
    public void printMap() throws Exception {

        Queen queen = new Queen(10);
        queen.space();
        queen.printMap();

        int a = 0, b=0;
        for (int i = 0; i < queen.map.length; i++) {
            a = a + i;
            for (int j = 0; j < queen.map[i].length; j++) {
                if(queen.map[i][j] == "Q"){
                    b = b + j;
                }
            }
        }
        assertEquals(a, b);

    }

}