package study.java.chapter3;

/**
 * Created by peterwang on 2017/2/1.
 */

public class Test1 {

    protected int GCD(int a, int b) {
        int d = a>=b?a:b;

        for(int i = d ; i >= 1 ; i--){
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }

}