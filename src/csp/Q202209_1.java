package csp;

import java.util.Scanner;

public class Q202209_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int[] arr=new int[a];

        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
        }
        int[] res=new int[a];
        int ci=1;
        int cj=1;
        int sum=0;
        for(int i=0;i<a;i++){
            ci*=arr[i];
            int temp=b%ci;
            res[i]=(temp-sum)/cj;
            sum+=cj*res[i];
            cj*=arr[i];
        }
        for(int i=0;i<a;i++){
            System.out.print(res[i]+" ");
        }
    }
}
