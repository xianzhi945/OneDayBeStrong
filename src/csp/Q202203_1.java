package csp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q202203_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        Set<Integer> set1=new HashSet<>();

        for(int i=1;i<=n;i++){
            set1.add(i);
        }
        int res=0;

        for(int i=0;i<k;i++){
            int a1=sc.nextInt();
            int a2=sc.nextInt();
            if(set1.contains(a2)){
                res++;

            }
            set1.remove(a1);


        }
        System.out.println(res);
    }
}
