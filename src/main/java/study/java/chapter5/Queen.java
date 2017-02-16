package study.java.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by peterwang on 2017/2/15.
 */
public class Queen {

    public String[][] map;
    private int squareWidth;

    public static void main(String[] args) {
        Queen queen = new Queen(10);
        queen.space();
        queen.printMap();
    }

    public Queen(int squareWidth) {
        this.loadMap(squareWidth);
    }

    public void loadMap(int squareWidth){
        this.setSquareWidth(squareWidth);
        this.createBlankMap();
    }

    public void createBlankMap(){

        int squareWidth = getSquareWidth();

        this.map = new String[squareWidth][squareWidth];

        for (int i = 0; i < squareWidth; i++) {
            for (int j = 0; j < squareWidth; j++) {
                this.map[i][j] = ".";
            }

        }
    }

    public void space(){

        int w = this.getSquareWidth();
        ArrayList<Integer> arrlist = new ArrayList<Integer>(w);

        for (int i = 0; i < w; i++) {
            arrlist.add(i);
        }

        Collections.shuffle(arrlist);

        int index;

        for (int i = 0; i < w; i++) {
            index = arrlist.get(i);
            this.map[i][index] = "Q";
        }

    }


    public void printMap(){
        for(String[] m : this.map){
            System.out.println(String.join(" ", m));
        }
    }

    public int getSquareWidth() {
        return squareWidth;
    }

    public void setSquareWidth(int squareWidth) {
        this.squareWidth = squareWidth;
    }
}
