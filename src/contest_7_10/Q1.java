package contest_7_10;

import java.util.Arrays;

public class Q1 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int time=0;
       while(amount[0]!=0||amount[1]!=0||amount[2]!=0){
            Arrays.sort(amount);
            if(amount[2]!=0&&amount[1]!=0){
                amount[2]--;
                amount[1]--;
                time++;
            }else if(amount[2]!=0){
                amount[2]--;
                time++;
            }
        }
        return time;
    }
    public static void main(String[] args) {

    }
}
