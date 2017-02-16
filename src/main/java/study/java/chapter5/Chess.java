package study.java.chapter5;

import java.util.ArrayList;

/**
 * Created by peterwang on 2017/2/16.
 */
public class Chess {

    public Chess() {
        this.knightGo();
    }


    public static void main(String[] args) {
        Chess chess = new Chess();
    }

    public void knightGo(){

        int[][] newBoard = this.formatBoard();
        int[] startPoint = this.getRandomStartPoint();
        ArrayList knight = this.formatKnight();

        // 取得騎士步數記錄
        ArrayList knightLog = this.play(newBoard , startPoint , knight);
        // 繪製騎士記錄棋盤
        this.drawBoard(knightLog);
    }

    /**
     * board 格式化 8*8 每個值為 0 的棋盤
     */
    public int[][] formatBoard(){
        int[][] board = new int[8][8];

        // do something

        return board;
    }

    /**
     * @return 取得隨機開始位置
     */
    public int[] getRandomStartPoint(){
        return new int[] {5,6};
    }

    /**
     * 初始化騎士執行記錄
     */
    public ArrayList formatKnight(){
        ArrayList knight = new ArrayList();
        return knight;
    }


    /**
     *
     * @param board
     * @param point
     * @param knight
     */
    public ArrayList play(int[][] board , int[] point , ArrayList knight){

        if(knight.size() == 64){

            return knight;
        }

        // 找尋所在座標上下左右為0的位置
        // 更新 board , point 與增加 knight 記錄
        // 直到騎士走完 64 步，返回騎士記錄並繪製出棋盤

        return this.play(board , point , knight);

    }

    private int[] findZeroPoint(int[][] board , int[] point){
        int[] zeroPoint = new int[2];

        // do something

        return zeroPoint;
    }

    /**
     * @param knightLog 騎士的步數與座標記錄
     */
    private void drawBoard(ArrayList knightLog){

    }



}
