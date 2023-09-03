package contest7_17;

import java.util.*;

public class Q2 {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        //Arrays.sort(numsDivide);
        Set<Integer> yin=new HashSet<>();
        yin.add(1);
        int n=numsDivide[0];
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                yin.add(i);
                if(n != i*i){
                    yin.add(n/i);
                }
            }
        }
        for(int i=1;i<numsDivide.length;i++){
            Set<Integer> removeList=new HashSet<>();

            for(int m:yin){
                if(gcd(m,numsDivide[i])==1){
                    removeList.add(m);
                }
            }
            for(int m:removeList){
                yin.remove(m);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(yin.contains(i)){
                return i;
            }
        }
        return -1;





    }
    int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
