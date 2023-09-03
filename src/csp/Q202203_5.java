package csp;

import java.util.Scanner;

public class Q202203_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double total=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            total+=arr[i];
        }
        double ave=total/n;
        double da=0;
        for(int i=0;i<n;i++){
            da=da+(ave-arr[i])*(ave-arr[i]);
        }
        da=da/n;
        da=Math.sqrt(da);
        for(int i=0;i<n;i++){
            System.out.println((arr[i]-ave)/da);
        }

    }
}
