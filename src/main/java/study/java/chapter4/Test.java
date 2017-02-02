package study.java.chapter4;


/**
 * Created by peterwang on 2017/2/1.
 */
public class Test {
    public static void main(String[] args) {

        System.out.println("========= Test 1 ==========");

        Test1 test1 = new Test1();
        test1.Fibonacci(10);

        System.out.println("========= Poker ==========");

        Poker poker = new Poker();
        int takeCount = 0;
        String[] takeCards = new String[13];

        String[] cards = poker.getNewPoker();
        for(String card : cards){
            takeCards[takeCount] = card;
            if(takeCount == 12){
                System.out.println(String.join(" ", takeCards));
                takeCount = 0;
            }else{
                takeCount++;
            }

        }

        System.out.println("=========");

        String[] shuffleCards = poker.shuffle();
        for(String card : shuffleCards){
            takeCards[takeCount] = card;
            if(takeCount == 12){
                System.out.println(String.join(" ", takeCards));
                takeCount = 0;
            }else{
                takeCount++;
            }
        }

        System.out.println("========= Bobble sort ==========");

        BubbleSort bubblesort = new BubbleSort();
        int[] bubbles = bubblesort.getBubble();

        System.out.println(String.join(" ", bubblesort.getList(bubbles , ",")));

        bubbles = bubblesort.sortAsc();
        System.out.println(String.join(" ", bubblesort.getList(bubbles , ",")));


        System.out.println("========= Get array index ==========");

        System.out.println("Where is 60 index ?");
        System.out.println(bubblesort.findIndex(60));

        System.out.println("Where is 90 index ?");
        System.out.println(bubblesort.findIndex(90));

    }
}
