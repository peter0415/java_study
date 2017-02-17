package study.java.chapter5;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by peterwang on 2017/2/16.
 */
public class HanoiTest {
    @org.junit.Test
    public void solve() throws Exception {

        int n = 3;

        Hanoi hanoi = new Hanoi();
        ArrayList<Hanoi.Move> game = hanoi.solve(n);
        game.forEach(move -> {
            System.out.println(move);
        });

        double chkNumber = Math.pow(2 , n)-1;

        assertEquals(game.size(), (int)chkNumber);

    }

}