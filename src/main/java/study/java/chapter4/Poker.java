package study.java.chapter4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by peterwang on 2017/2/1.
 */
public class Poker {

    String[] suits = {"磚","桃","梅","心"};
    String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    String[] cards = new String[52];


    public String[] getNewPoker(){

        int cardCount = 0;
        for(String suit : this.suits){
            for(String number : this.numbers){
                this.cards[cardCount] = suit+number;
                cardCount ++;
            }
        }

        return this.cards;
    }

    public String[][] shuffle(String[] cards, int player){
        Random rnd = new Random();

        for (int i=0; i < cards.length; i++) {
            int randomPosition = rnd.nextInt(cards.length);
            // swap
            String temp = cards[i];
            cards[i] = cards[randomPosition];
            cards[randomPosition] = temp;
        }

        return this.licensing(cards, player);
    }

    public String[][] licensing(String[] cards , int player){

        int playerNeedCards = 52/player;
        int getCount = 0 , playerId = 0;
        String[][] playerGetCards = new String[4][playerNeedCards];

        for (String card : cards) {
            playerGetCards[playerId][getCount] = card;
            if (getCount == (playerNeedCards -1)) {
                //System.out.println(Arrays.toString(playerGetCards[playerId]));
                getCount = 0;
                playerId++;
            } else {
                getCount++;
            }
        }

        return playerGetCards;
    }

    public void printPoker(String[][] cards){
        for(String[] cc : cards){
            System.out.println(Arrays.toString(cc));
        }
    }
}
