package study.java.chapter3;

import com.sun.tools.internal.xjc.util.StringCutter;

/**
 * Created by peterwang on 2017/1/26.
 */
public class Test {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.GCD(1000 , 495));

        Test2 test2 = new Test2();
        test2.armstrong();
    }

}
