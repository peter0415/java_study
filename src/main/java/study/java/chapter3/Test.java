package study.java.chapter3;

/**
 * Created by peterwang on 2017/2/2.
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();

        System.out.println("\n=== GCD ===\n");
        System.out.println(t.gcd(1000 , 495));

        System.out.println("\n=== Armstrong ===\n");
        t.armstrong();

    }

    public int gcd(int a, int b) {
        int d = a>=b?a:b;

        for (int i = d ; i >= 1 ; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public void armstrong() {
        int x,y,z,res;
        for (int i=100 ; i <= 999 ; i ++) {
            x = i / 100;
            y = i % 100 / 10;
            z = i % 10;

            res = (int)Math.pow(x, 3) + (int)Math.pow(y, 3) + (int)Math.pow(z, 3);

            if (res == i) {
                System.out.println(i);
            }
        }
    }

}
