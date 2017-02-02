package study.java.chapter3;

/**
 * Created by peterwang on 2017/2/1.
 */
public class Test2 {

    protected void armstrong(){
        int x,y,z,res;
        for(int i=100 ; i <= 999 ; i ++){
            String numStr = String.valueOf(i);
            String[] numArr = numStr.split("");
            x = Integer.valueOf(numArr[0]);
            y = Integer.valueOf(numArr[1]);
            z = Integer.valueOf(numArr[2]);

            res = (int)Math.pow(x, 3) + (int)Math.pow(y, 3) + (int)Math.pow(z, 3);

            if(res == i){
                System.out.println(i);
            }
        }
    }
}
