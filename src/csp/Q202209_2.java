package csp;

import java.util.Scanner;

public class Q202209_2 {
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int[] arr=new int[a];
        int[] pre=new int[a+1];

        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
            pre[i+1]=arr[i]+pre[i];
        }
        dfs(pre,arr,0,0,b);
        System.out.println(min);


    }
    public static void dfs(int[] pre,int[] arr,int sum,int index,int b){
        if(pre[arr.length]-pre[index]+sum<b){
            //System.out.println(pre[arr.length]+" "+pre[index+1]+" "+b);
            return;
        }
        if(sum>=b){
            min=Math.min(min,sum);
        }
        if(index==arr.length){
            return;
        }

        dfs(pre,arr,sum+arr[index],index+1,b);
        dfs(pre,arr,sum,index+1,b);


    }

}
