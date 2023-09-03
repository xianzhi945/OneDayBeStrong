package contest6_25;

import java.util.*;

public class Test {



    int[] f;
    int[] size;
    int[] rank;
    Map<Integer,Integer> map=new HashMap();
    public long countPairs(int n, int[][] edges) {
        f=new int[n];
        size=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            f[i]=i;
            size[i]=1;
            rank[i]=1;
        }
        for(int i=0;i<edges.length;i++){
            union(edges[i][0],edges[i][1]);
        }
             List<Integer> list=new ArrayList<>();
             for(int i:map.keySet()){
                 list.add(map.get(i));
                 System.out.println(i+" "+map.get(i));
             }
             long res=0;
        for(int i=0;i<map.keySet().size()-1;i++){
            for(int j=i+1;j< list.size();j++){
                res+=(long)list.get(i)*(long)list.get(j);
            }
        }
        return res;
    }


    public int find(int x){
        if (f[x] == x) {
            return f[x];
        }
        return f[x] = find(f[x]);
    }
    public void union(int i,int j){
        int fx=find(i);
        int fy=find(j);
        if(fx!=fy){
            if(rank[fx] < rank[fy]){
                f[fx]= fy;
                size[fy]+=size[fx];
                map.put(fy,size[fy]);
            } else if(rank[fx]>rank[fy]) {
                f[fy]= fx;
                size[fx]+=size[fy];
                map.put(fx,size[fx]);
            }else{
                f[fx]= fy;
                size[fy]+=size[fx];
                map.put(fy,size[fy]);
                rank[fx]++;
            }

        }
    }



}
