package study.java.chapter4;

import java.util.Random;

/**
 * Created by peterwang on 2017/2/1.
 */
public class Poker {

    String[] suits = {"磚","桃","梅","心"};
    String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    String[] cards = new String[52];

    protected String[] getNewPoker(){

        int cardCount = 0;
        for(String suit : this.suits){
            for(String number : this.numbers){
                //System.out.println(suit+number);
                this.cards[cardCount] = suit+number;
                cardCount ++;
            }
        }
        return this.cards;
    }

    protected String[] shuffle(){
        Random rnd = new Random();

        for (int i=0; i < this.cards.length; i++) {
            int randomPosition = rnd.nextInt(this.cards.length);
            String temp = this.cards[i];
            this.cards[i] = this.cards[randomPosition];
            this.cards[randomPosition] = temp;
        }

        return cards;
    }
}
