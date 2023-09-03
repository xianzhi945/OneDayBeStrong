package csp;

import java.util.*;

public class Q202209_4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int q=sc.nextInt();
        if(m==1){
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for(int i=0;i<q;i++){
                int t=sc.nextInt();
                if(t==1){
                    int l=sc.nextInt();
                    int r=sc.nextInt();
                    int x=sc.nextInt();
                    if(map.containsKey(l)){
                        map.put(l,Math.max(map.get(l),r));
                    }else{
                        map.put(l,r);
                    }


                }else if(t==2){
                    int x=sc.nextInt();
                    int w=sc.nextInt();
                    map.clear();

                }else if(t==3){
                    int x=sc.nextInt();
                    int y=sc.nextInt();
                    map.clear();
                }else if(t==4){
                    int w=sc.nextInt();
                    int ans=0;
                    int ll=0;int rr=0;
                    if(map.isEmpty()){
                        System.out.println(0);
                    }else{
                        for(int k:map.keySet()){
                            int v=map.get(k);
                            if(k>rr){
                                ll=k;
                                rr=v;
                                ans+=(rr-ll+1);
                            }else if(v<=rr){
                                continue;
                            }else if(v>rr){
                                ans+=(v-rr);
                                rr=v;
                            }
                        }
                        System.out.println(ans);
                    }
                }else if(t==5){
                    if(map.isEmpty()){
                        System.out.println(0);
                    }else{
                        System.out.println(1);
                    }
                }
            }
            return;
        }

        int[] a=new int[n];
        for(int i=0;i<q;i++){
            int t=sc.nextInt();
            if(t==1){
                int l=sc.nextInt();
                int r=sc.nextInt();
                int x=sc.nextInt();
                for(int j=l;j<=r;j++){
                    a[j]=x;
                }
            }else if(t==2){
                int x=sc.nextInt();
                int w=sc.nextInt();
                for(int j=0;j<n;j++){
                    if(a[j]==x){
                        a[j]=w;
                    }
                }

            }else if(t==3){
                int x=sc.nextInt();
                int y=sc.nextInt();
                for(int j=0;j<n;j++){
                    if(a[j]==x){
                        a[j]=y;
                    }else if(a[j]==y){
                        a[j]=x;
                    }
                }
            }else if(t==4){
                int w=sc.nextInt();
                int ans=0;
                for(int ii=0;ii<n;ii++){
                    if(w==a[ii]){
                        ans++;
                    }
                }

                System.out.println(ans);

            }else if(t==5){
                int[] mm=new int[m+1];
                for(int ii=0;ii<n;ii++){
                    mm[a[ii]]++;
                }
                int max=0;
                int maxIndex=0;
                for(int ii=1;ii<=m;ii++){

                    if(mm[ii]>max){
                        max=mm[ii];
                        maxIndex=ii;
                    }
                }
                System.out.println(maxIndex);
            }
        }


    }
}
