package study.java.chapter4;

import java.util.Arrays;

/**
 * Created by peterwang on 2017/2/1.
 */
public class Test {
    public static void main(String[] args) {

        Test t = new Test();


        __iamline__("Fibonacci");

        System.out.println(Arrays.toString(t.fibonacci(10 )));


        __iamline__("New Poker");

        Poker poker = new Poker();

        String[] cards = poker.getNewPoker();

        String[][] newPoker = poker.licensing(cards,4);
        poker.printPoker(newPoker);

        __iamline__("Shuffle Poker");

        String[][] shufflePoker = poker.shuffle(cards,4);
        poker.printPoker(shufflePoker);

        __iamline__("Bobble sort");

        BubbleSort bubblesort = new BubbleSort();
        int[] bubbles = bubblesort.getBubble();

        System.out.println(String.join(" ", bubblesort.getList(bubbles , ",")));

        bubbles = bubblesort.sortAsc();
        System.out.println(String.join(" ", bubblesort.getList(bubbles , ",")));

        __iamline__("Where is 60 index ?");
        System.out.println(bubblesort.findIndex(60));

        __iamline__("Where is 90 index ?");
        System.out.println(bubblesort.findIndex(90));

    }

    public static void __iamline__(String msg){
        System.out.println("\n========= "+ msg +" ==========\n");
    }

    public static int[] fibonacci(int months ){
        // S:小兔 , B:大兔
        int S = 0, B = 0, STmp = 0, BTmp = 0;
        int[] F = new int[months];

        for (int i = 0 ; i < months ; i++) {

            // 計算該月所有總和
            F[i] = S + B;

            // 計算下月大小兔各別數量
            STmp = (i == 0)?1:B;
            BTmp = S + B;
            S = STmp;
            B = BTmp;
        }

        return F;
    }

}
