package study.java.chapter4;

/**
 * Created by peterwang on 2017/2/1.
 */
class Test1 {

    protected void Fibonacci(int months){
        this.getRabbits(months , 0,0,0);
    }

    private void getRabbits(int months , int count , int f1 , int f2){
        if(months == count) return;
        if(count == 1) f1 = f1 + 1;
        System.out.println(f1+f2);
        this.getRabbits(months,count + 1 , f2, f1+f2);
    }
}
