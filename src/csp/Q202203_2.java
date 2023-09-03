package csp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q202203_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int[][] arr=new int[n][2];
        int[] a=new int[200005];
        for(int i=0;i<n;i++){
            int a1=sc.nextInt();
            int a2=sc.nextInt();
            arr[i][0]=a1-k-a2;
            arr[i][1]=a1-k;

            for(int j=Math.max(arr[i][0]+1,0);j<=arr[i][1];j++){
                a[j]++;
            }
        }
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//
//        int left=0;
//        int right=0;


//        for(int i=0;i<n;i++){
//            System.out.println(arr[i][0]+" "+arr[i][1]);
//        }
        //至少在什么时间做才行
//        for(int i=0;i<m;i++){
//            int t=sc.nextInt();
//
//            int res=0;
//            for(int j=0;j<n;j++){
//
//                if(arr[j][0]<t&&arr[j][1]>=t){
//                    //System.out.println(j);
//                    res++;
//                    continue;
//                }
//                if(arr[j][0]>t){
//                    break;
//                }
//
//            }
        for(int i=0;i<m;i++){
            int t=sc.nextInt();
            System.out.println(a[t]);
        }




    }
}
