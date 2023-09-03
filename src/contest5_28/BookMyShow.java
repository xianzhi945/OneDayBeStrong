package contest5_28;

class BookMyShow {
    int[] b;
    int n;
    int m;
    public BookMyShow(int n, int m) {
        b=new int[n];
        this.n=n;
        this.m=m;
    }

    public int[] gather(int k, int maxRow) {
        if(k>m){
            return new int[]{};
        }
        for(int i=0;i<=maxRow;i++){
            if(b[i]+k<=m){
                int[] res=new int[2];
                res[0]=i;
                res[1]=b[i];
                b[i]+=k;
                return res;

            }
        }
        return new int[]{};
    }

    public boolean scatter(int k, int maxRow) {
        long temp=0;
        for(int i=0;i<=maxRow;i++){
            temp+=(m-b[i]);
            if(temp>=k){
                break;
            }
        }
        if(temp<k){
            return false;
        }else{
            for(int i=0;i<=maxRow;i++){
                k=k-(m-b[i]);
                if(k<=0){
                    b[i]=k+m;
                    return true;
                }else{
                    b[i]=m;
                }

            }
            return true;
        }
    }
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */