package contest5_28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<roads.length;i++){
            map.put(roads[i][0],map.getOrDefault(roads[i][0],0)+1);
            map.put(roads[i][1],map.getOrDefault(roads[i][1],0)+1);
        }
        int[] temp=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=map.getOrDefault(i,0);
        }
        Arrays.sort(temp);
        long res=0;
        for(int i=0;i<n;i++){
            res+=(long)(temp[i]*(long)(i+1));
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
