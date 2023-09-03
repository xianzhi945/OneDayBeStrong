    package csp;

    import java.util.Comparator;
    import java.util.PriorityQueue;
    import java.util.Scanner;
    class Time{
        int u;
        int v;
        int x;
        int date;
    }
    public class Q202203_4 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            long[][] a=new long[n+1][n+1];
            int m=sc.nextInt();
            int[] arr=new int[n+1];
            PriorityQueue<Time> queue=new PriorityQueue<>(new Comparator<Time>() {
                @Override
                public int compare(Time o1, Time o2) {
                    return o1.date-o2.date;
                }
            });

            for(int i=0;i<m;i++){
                //先更新
                while(!queue.isEmpty()){
                    if(queue.peek().date<=i){
                        Time time=queue.poll();
                        //  System.out.println("今天是"+i+"被删除的"+time.u+" "+time.v);
                        a[time.u][time.v]-=time.x;
                        a[time.v][time.u]-=time.x;
                    }else {
                        //System.out.println("最小的"+queue.peek().date);
                        break;
                    }
                }


                int ki=sc.nextInt();
                for(int j=0;j<ki;j++){
                    int u=sc.nextInt();
                    int v=sc.nextInt();
                    int x=sc.nextInt();
                    int y=sc.nextInt();
                    a[u][v]+=x;
                    a[v][u]+=x;
                    Time time=new Time();
                    time.u=u;time.v=v;time.x=x;time.date=y+i;
                    queue.add(time);
                }

                for(int j=1;j<n+1;j++){
                    long max=0;
                    int maxIndex=0;
                    for(int q=1;q<n+1;q++){
                        if(q!=j){
                            if(a[q][j]>max){
                                max=a[q][j];
                                maxIndex=q;
                            }
                        }
                    }
                    arr[j]=maxIndex;
                }
    //            for(int j:arr){
    //                System.out.print(j+" ");
    //            }
    //            System.out.println();

                int li=sc.nextInt();
                for(int j=0;j<li;j++){
                    int t=sc.nextInt();
                    System.out.println(arr[t]);
                }

                int pi=sc.nextInt();
                if(pi==1){
                    //查岛
                    int num=0;
                    for(int j=1;j<n+1;j++){
                        if(arr[j]==0){
                            num++;
                        }
                    }
                    System.out.println(num);
                }

                int qi=sc.nextInt();
                if(qi==1){
                    int res=0;
                    for(int j=1;j<n+1;j++){
                       // System.out.print(temp[j]+" ");
                        if(arr[arr[j]]==j){
                            res++;
                        }
                    }
                    //System.out.println();
                    System.out.println(res/2);
                }
            }
        }
    }
