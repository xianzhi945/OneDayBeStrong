package contest5_28;

public class Test4 {
    int[][] a;
    int[] b;
    int n;
    int m;
    int total;
    public Test4(int n, int m) {
        a=new int[n][m];
        b=new int[n];
        this.n=n;
        this.m=m;
        total=0;
    }

    public int[] gather(int k, int maxRow) {
        int[] res=new int[2];
        if(k>m){
            return res;
        }
        for(int i=0;i<maxRow;i++){
            System.out.println(b[i]);
            if(b[i]+k<m){
                res[0]=i;
                res[1]=b[i];
                b[i]+=k;
            }
        }
        return res;
    }

    public boolean scatter(int k, int maxRow) {

        long temp=0;
        for(int i=0;i<maxRow;i++){
            temp+=(m-b[i]);
        }
        if(temp<k){
            return false;
        }else{
            for(int i=0;i<maxRow;i++){
                k=k-(m-b[i]);
                if(k<=0){
                    b[i]+=k+(m-b[i]);
                    return true;
                }else{
                    b[i]=m;
                }

            }
            return true;
        }
    }
    public static void main(String[] args) {

    }
}
