package study.java.chapter4;

/**
 * Created by peterwang on 2017/2/2.
 */
public class BubbleSort {

    int[] bubble = {70,80,31,37,10,1,48,60,33,80};

    protected int[] getBubble(){
        return this.bubble;
    }

    protected void setBubble(int[] newBubble){
        this.bubble = newBubble;
    }

    protected int[] sortAsc(){
        int tmp = 0;
        boolean sortAgain = false;
        for(int i = 0 ; i < this.bubble.length -1 ; i ++){
            if(this.bubble[i] > this.bubble[i+1]){
                tmp = this.bubble[i];
                this.bubble[i] = this.bubble[i+1];
                this.bubble[i+1] = tmp;
                sortAgain = true;
            }
        }

        if(sortAgain) this.sortAsc();

        return this.bubble;
    }

    protected  int[] sortDesc(){
        return this.bubble;
    }

    protected String getList(int[] bubbles, String joinStr){
        String[] bubblesArr = new String[bubbles.length];
        int bubblesCount = 0;
        for(int bubble : bubbles){
            bubblesArr[bubblesCount] = String.valueOf(bubble);
            bubblesCount++;
        }

        return String.join(joinStr, bubblesArr);
    }

    protected int findIndex(int val){
        int index = -1;
        for(int i = 0; i < this.bubble.length; i ++ ){
            if(this.bubble[i] == val){
                index = i;
            }
        }
        return index;
    }
}
