package csp;

import java.util.*;
class Point{
    int x;
    int y;
    public Point(int xx,int yy){
        x=xx;
        y=yy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
class Jingzi{

    int flag;//-1 右转下 下转右  左转上 上转左 1 右转上 上转右 左转下 下转左
    int operation;
    double rate;
    public Jingzi(int flag,int operation,double rate){

        this.flag=flag;
        this.rate=rate;
        this.operation=operation;
    }

}
public class Q202206_4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        Set<Jingzi> set=new HashSet<>();
        Map<Point,Jingzi> map=new HashMap<>();
        for(int s=1;s<=m;s++){
           int t=sc.nextInt();
           if(t==1){
               int x1=sc.nextInt();
               int y1=sc.nextInt();
               int x2=sc.nextInt();
               int y2=sc.nextInt();
               double rate=sc.nextDouble();

               int k=(y2-y1)/(x2-x1);
               int b=y1-k*x1;
               int minx=Math.min(x1,x2);
               int maxx=Math.max(x1,x2);
               minx++;
               while(minx<maxx){
                   int y=k*minx+b;
                   Point point=new Point(minx,y);
                   Jingzi jingzi=new Jingzi(k,s,rate);
                   map.put(point,jingzi);
                   minx++;
               }
           }else if(t==2){
               int num=sc.nextInt();
                Map<Point,Jingzi> temp=new HashMap<>();

                for(Point point:map.keySet()){
                    if(map.get(point).operation!=num){
                        temp.put(point,map.get(point));
                    }
                }
                map=temp;


           }else{
               int x=sc.nextInt();
               int y=sc.nextInt();
                int d=sc.nextInt();

                double I=sc.nextDouble();
                int time=sc.nextInt();
                int curr=0;
                while(curr<time){
                    curr+=1;
                    if(d==0){
                        x++;
                    }if(d==1){
                        y++;
                    }if(d==2){
                        x--;
                    }if(d==3){
                        y--;
                    }
                    Point point=new Point(x,y);
                    if(map.containsKey(point)){
                        Jingzi jingzi=map.get(point);
                       // System.out.println(x+" "+ y+" "+jingzi.flag);
                        if(jingzi.flag==-1){
                            if(d==0){//右转下
                                d=3;
                            }else if(d==1){
                                d=2;
                            }else if(d==2){
                                d=1;
                            }else if(d==3){
                                d=0;
                            }
                        }else{
                            if(d==0){//右转上
                                d=1;
                            }else if(d==1){
                                d=0;
                            }else if(d==2){
                                d=3;
                            }else if(d==3){
                                d=2;
                            }
                        }
                        I=I*jingzi.rate;
                        if(I<1){
                            System.out.println("0 0 0");
                            break;
                        }
                    }
                }
               if(I>1){
                   System.out.println(x+" "+y+" "+(int)Math.floor(I));
               }
           }
        }
    }
}
