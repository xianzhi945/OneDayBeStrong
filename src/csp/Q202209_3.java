package csp;

import java.util.*;

class Node{
    int d;
    int u;
    int r;
}

public class Q202209_3 {

    public static void main(String[] args) {
        Set<Integer>[] set=new HashSet[1050];
        List<Node>[] v=new ArrayList[1050];
        for(int i=0;i<1050;i++){
            set[i]=new HashSet<>();
            v[i]=new ArrayList<>();
        }
        Set<Integer> res=new TreeSet<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ri;
        int mi;
        for(int i=0;i<n;i++){
            ri=sc.nextInt();
            mi=sc.nextInt();
            for(int j=1;j<=ri;j++){
                int p=sc.nextInt();
                for(int k=i;k<i+7;k++){
                    set[k].add(p);//表示从i天p地区一直到i+7时间内为风险地区
                }
            }

            //漫游数据
            for(int j=0;j<mi;j++){
                Node node =new Node();
                node.d=sc.nextInt();
                node.u=sc.nextInt();
                node.r=sc.nextInt();
                if(node.d<0){
                    continue;
                }
                v[i].add(node);
            }
            for(int j=Math.max(0,i-6);j<=i;j++){
                for(int k=0;k<v[j].size();k++){
                    int d=v[j].get(k).d;
                    int r=v[j].get(k).r;
                    int u=v[j].get(k).u;

                    if(d<i-6){
                        continue;
                    }
                    boolean flag=true;
                    for(int day=d;day<=i;day++){
                        if(!set[day].contains(r)){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        res.add(u);
                    }
                }
            }
            System.out.print(i+" ");
            for(int re:res){
                System.out.print(re+" ");
            }
            System.out.println();
            res.clear();
        }
    }
}
