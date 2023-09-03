package contest4_17;

import java.util.*;

public class Q2 {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        int res=0;
        for(int i:map.keySet()){
            int num=map.get(i);
            if(num<2){
                return -1;
            }else{
                int t=num/3;
                int m=num%3;
                if(m!=0){
                    t++;
                }
                res+=t;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        for(Integer i:queue){
            System.out.println(i);
        }

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());

    }
}
