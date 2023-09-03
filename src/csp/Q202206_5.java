package csp;

import java.util.Scanner;

public class Q202206_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        double[][] points = new double[n][2];
        for(int i = 0; i < n; i++){
            points[i][0] = scan.nextDouble();
            points[i][1] = scan.nextDouble();
        }

        int id,l,r;
        double a,b,s,x,y;
        double d,ra;
        while (p > 0){
            id = scan.nextInt();
            l = scan.nextInt();
            r = scan.nextInt();
            switch (id){
                case 1:
                    a = scan.nextDouble();
                    b = scan.nextDouble();
                    for (int i = l-1; i < r; i++){
                        points[i][0] += a;
                        points[i][1] += b;
                    }
                    break;
                case 2:
                    a = scan.nextDouble();
                    b = scan.nextDouble();
                    s = scan.nextDouble();
                    for (int i = l-1; i < r; i++) {
                        x = points[i][0] - a;
                        y = points[i][1] - b;
                        d = Math.sqrt(x*x+y*y);
                        ra = Math.atan2(y,x) + s;
                        points[i][0] = d * Math.cos(ra) + a;
                        points[i][1] = d * Math.sin(ra) + b;
                    }
                    break;
                case 3:
                    a = scan.nextDouble();
                    b = scan.nextDouble();
                    s = scan.nextDouble();
                    for (int i = l-1; i < r; i++) {
                        points[i][0] = (points[i][0] - a) * s + a;
                        points[i][1] = (points[i][1] - b) * s + b;
                    }
                    break;
                case 4:
                    s = scan.nextDouble();
                    b = scan.nextDouble();
                    for (int i = l-1; i < r; i++) {
                        x = points[i][0];
                        y = points[i][1] - b;
                        d = Math.sqrt(x*x+y*y);
                        ra = 2 * s - Math.atan2(y, x);
                        points[i][0] = d * Math.cos(ra);
                        points[i][1] = d * Math.sin(ra) + b;
                    }
                    break;
                case 5:
                    s = scan.nextDouble();
                    b = scan.nextDouble();
                    for (int i = l-1; i < r; i++) {
                        x = points[i][0];
                        y = points[i][1] - b;
                        ra = Math.atan2(y, x) - s;
                        d = Math.sqrt(x*x+y*y) * Math.cos(ra);

                        points[i][0] = d * Math.cos(s);
                        points[i][1] = d * Math.sin(s) + b;
                    }
                    break;
                case 6:
                    double totalX=0;
                    double totalY=0;
                    for (int i = l-1; i < r; i++) {
                        totalX += points[i][0];
                        totalY += points[i][1];
                    }
                    System.out.printf("%.6f %.6f\n",totalX/(r-l+1),totalY/(r-l+1));
                    break;
                case 7:
                    double total = 0;
                    a = scan.nextDouble();
                    b = scan.nextDouble();
                    for (int i = l-1; i < r; i++) {
                        total += (points[i][0] - a) * (points[i][0] - a) + (points[i][1] - b) * (points[i][1] - b);
                    }
                    System.out.printf("%.6f\n", total);
                    break;
            }
            p--;
        }
    }
}
