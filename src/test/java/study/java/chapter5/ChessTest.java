package study.java.chapter5;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by peterwang on 2017/2/16.
 */
public class ChessTest {
    @org.junit.Test
    public void play() throws Exception {
        Chess chess = new Chess();

        int[][] newBoard = chess.formatBoard();
        int[] startPoint = chess.getRandomStartPoint();
        ArrayList knight = chess.formatKnight();

        // 取得騎士步數記錄
        ArrayList knightLog = chess.play(newBoard , startPoint , knight);

        // 判斷 knightLog.size 是否等於 1+2+...+64 的和
    }

}