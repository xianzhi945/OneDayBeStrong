package contest4_17;

public class Q3 {
//    public int maxTrailingZeros(int[][] grid) {
//        int tenNum=0;
//        int fiveNum=0;
//        int twoNum=0;
//        int max=0;
//        int res=0;
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                //1
//                tenNum=0;
//                fiveNum=0;
//                twoNum=0;
//                res=0;
//                for(int t=0;t<=i;t++){
//                    tenNum+=get(grid[t][j],10);
//                    fiveNum+=get(grid[t][j],5);
//                    twoNum+=get(grid[t][j],2);
//                }
//                for(int t=0;t<=j;t++){
//                    tenNum+=get(grid[i][t],10);
//                    fiveNum+=get(grid[i][t],5);
//                    twoNum+=get(grid[i][t],2);
//                }
//                tenNum-=get(grid[i][j],10);
//                fiveNum-=get(grid[i][j],5);
//                twoNum-=get(grid[i][j],2);
//                res=tenNum+Math.min(fiveNum-tenNum,twoNum-tenNum);
//                if(res>max){
//                    max=res;
//                }
//                System.out.println(i+" "+j+" "+res+" "+tenNum+" "+" "+fiveNum+" "+twoNum);
//                //2
//                tenNum=0;
//                fiveNum=0;
//                twoNum=0;
//                res=0;
//                for(int t=i;t<grid.length;t++){
//                    tenNum+=get(grid[t][j],10);
//                    fiveNum+=get(grid[t][j],5);
//                    twoNum+=get(grid[t][j],2);
//                }
//                for(int t=0;t<=j;t++){
//                    tenNum+=get(grid[i][t],10);
//                    fiveNum+=get(grid[i][t],5);
//                    twoNum+=get(grid[i][t],2);
//                }
//                tenNum-=get(grid[i][j],10);
//                fiveNum-=get(grid[i][j],5);
//                twoNum-=get(grid[i][j],2);
//                res=tenNum+Math.min(fiveNum-tenNum,twoNum-tenNum);
//                if(res>max){
//                    max=res;
//                }
//                System.out.println(i+" "+j+" "+res+" "+tenNum+" "+" "+fiveNum+" "+twoNum);
//                //3
//                tenNum=0;
//                fiveNum=0;
//                twoNum=0;
//                res=0;
//                for(int t=i;t<grid.length;t++){
//                    tenNum+=get(grid[t][j],10);
//                    fiveNum+=get(grid[t][j],5);
//                    twoNum+=get(grid[t][j],2);
//                }
//                for(int t=j;t<grid[0].length;t++){
//                    tenNum+=get(grid[i][t],10);
//                    fiveNum+=get(grid[i][t],5);
//                    twoNum+=get(grid[i][t],2);
//                }
//                tenNum-=get(grid[i][j],10);
//                fiveNum-=get(grid[i][j],5);
//                twoNum-=get(grid[i][j],2);
//                res=tenNum+Math.min(fiveNum-tenNum,twoNum-tenNum);
//                if(res>max){
//                    max=res;
//                }
//                System.out.println(i+" "+j+" "+res+" "+tenNum+" "+" "+fiveNum+" "+twoNum);
//                //4
//                tenNum=0;
//                fiveNum=0;
//                twoNum=0;
//                res=0;
//                for(int t=0;t<=i;t++){
//                    tenNum+=get(grid[t][j],10);
//                    fiveNum+=get(grid[t][j],5);
//                    twoNum+=get(grid[t][j],2);
//                }
//                for(int t=j;t<grid[0].length;t++){
//                    tenNum+=get(grid[i][t],10);
//                    fiveNum+=get(grid[i][t],5);
//                    twoNum+=get(grid[i][t],2);
//                }
//                tenNum-=get(grid[i][j],10);
//                fiveNum-=get(grid[i][j],5);
//                twoNum-=get(grid[i][j],2);
//                res=tenNum+Math.min(fiveNum-tenNum,twoNum-tenNum);
//                if(res>max){
//                    max=res;
//                }
//                System.out.println(i+" "+j+" "+res+" "+tenNum+" "+" "+fiveNum+" "+twoNum);
//            }
//        }
//        return max;
//    }
public int maxTrailingZeros(int[][] grid) {

    int max=0;

    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
             max=Math.max(max,getMax(grid,i,j));
        }
    }
    return max;
}

    int getMax(int[][] grid,int i,int j){
        int tenNum1=0;
        int fiveNum1=0;
        int twoNum1=0;
        int tenNum2=0;
        int fiveNum2=0;
        int twoNum2=0;
        int tenNum3=0;
        int fiveNum3=0;
        int twoNum3=0;
        int tenNum4=0;
        int fiveNum4=0;
        int twoNum4=0;
        for(int t=0;t<=i;t++){
            tenNum1+=get(grid[t][j],10);
            fiveNum1+=get(grid[t][j],5);
            twoNum1+=get(grid[t][j],2);

        }
        for(int t=i;t<grid.length;t++){
            tenNum2+=get(grid[t][j],10);
            fiveNum2+=get(grid[t][j],5);
            twoNum2+=get(grid[t][j],2);
        }

        for(int t=0;t<=j;t++){
            tenNum3+=get(grid[i][t],10);
            fiveNum3+=get(grid[i][t],5);
            twoNum3+=get(grid[i][t],2);
        }
        for(int t=j;t<grid[0].length;t++){
            tenNum4+=get(grid[i][t],10);
            fiveNum4+=get(grid[i][t],5);
            twoNum4+=get(grid[i][t],2);
        }
        int res=0;
        //                tenNum-=get(grid[i][j],10);
//                fiveNum-=get(grid[i][j],5);
//                twoNum-=get(grid[i][j],2);
        res=Math.max(res,tenNum1+tenNum3-get(grid[i][j],10)+Math.min(fiveNum1+fiveNum3-get(grid[i][j],5)-(tenNum1+tenNum3-get(grid[i][j],10)),(twoNum1+twoNum3-get(grid[i][j],2))-(tenNum1+tenNum3-get(grid[i][j],10))));

        res=Math.max(res,tenNum2+tenNum3-get(grid[i][j],10)+Math.min(fiveNum2+fiveNum3-get(grid[i][j],5)-(tenNum2+tenNum3-get(grid[i][j],10)),(twoNum2+twoNum3-get(grid[i][j],2))-(tenNum2+tenNum3-get(grid[i][j],10))));

        res=Math.max(res,tenNum2+tenNum4-get(grid[i][j],10)+Math.min(fiveNum2+fiveNum4-get(grid[i][j],5)-(tenNum2+tenNum4-get(grid[i][j],10)),(twoNum2+twoNum4-get(grid[i][j],2))-(tenNum2+tenNum4-get(grid[i][j],10))));

        res=Math.max(res,tenNum1+tenNum4-get(grid[i][j],10)+Math.min(fiveNum1+fiveNum4-get(grid[i][j],5)-(tenNum1+tenNum4-get(grid[i][j],10)),(twoNum1+twoNum4-get(grid[i][j],2))-(tenNum1+tenNum4-get(grid[i][j],10))));

        return res;
    }

    int get(int a,int s){
        int res=0;
        while(a%s==0){
            res++;
            a=a/s;
        }
        return res;
    }


    public int countTexts(String pressedKeys) {
        long result=1;
        int n=pressedKeys.length();
        int i=0;
        int j=1;
        while(i<n&&j<=n){
            if(j==n||pressedKeys.charAt(i)!=pressedKeys.charAt(j)){
                if(pressedKeys.charAt(i)=='7'||pressedKeys.charAt(i)=='9'){
                    result*=compute(4,(j-i));
                }else{
                    result*=compute(3,(j-i));
                }
                i=j;
            }
            else{
                j++;
            }
        }
        return (int)result%1000000007;
    }
    public long compute(int flag,int times){
        long[] a=new long[times];
        int total=0;
        for(int i=0;i<flag;i++){
            a[i]= (long) Math.pow(2,i);
            total+=a[i];
        }
        for(int i=flag;i<times;i++){
            a[i]=total;
            total+=a[i];
        }
        return a[times-1];
    }
    public static void main(String[] args) {
        int[][] grid=new int[][]{{23,17,15,3,20},{8,1,20,27,11},{9,4,6,2,21},{40,9,1,10,6},{22,7,4,5,3}};
        Q3 q3=new Q3();
       // System.out.println(  q3.maxTrailingZeros(grid));

        System.out.println(q3.getMax(grid,0,2));

    }
}
