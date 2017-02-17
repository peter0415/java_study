package study.java.chapter5;

import java.util.ArrayList;

/**
 * Created by peterwang on 2017/2/16.
 */
public class Hanoi {
    public class Move {
        public String from, to, xxx;

        public Move(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Move{" +
                    "from='" + from + '\'' +
                    ", to='" + to + '\'' +
                    ", xxx='" + xxx + '\'' +
                    '}';
        }
    }

    public ArrayList<Move> solve(int n) {
        moves = new ArrayList<Move>();
        move(n, "A", "B", "C");
        return moves;
    }

    private ArrayList moves;

    private void move(int n, String a, String b, String c) {
        if(n == 1) {
            moves.add(new Move(a, c));
        } else {
            move(n - 1, a, c, b);
            move(1, a, b, c);
            move(n - 1, b, a, c);
        }
    }

    public static void main(String args[]) {
        Hanoi hanoi = new Hanoi();


        for(Move move : hanoi.solve(3)) {
            System.out.println(move.from +" => "+ move.to);
        }
    }
}
