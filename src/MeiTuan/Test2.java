    package MeiTuan;
    import java.util.*;

    public class Test2 {
        public static void main(String args[]){
            Scanner reader=new Scanner(System.in);
            while(reader.hasNextInt()){
                int m=reader.nextInt();
                Set<Integer> set=new HashSet<Integer>();
                int[] a=new int[m];
                for(int i=0;i<m;i++){
                    a[i]=reader.nextInt();
                }
                int[] res=new int[m];
                for(int i=0;i<m;i++){
                    if(i==0){
                        res[i]=1;
                    }else{
                        set.clear();
                        set.add(a[0]);
                        set.add(a[i]);
                        int index=i+1;
                        for(int j=2;j<=index/2;j++){
                            if(index%j==0){
                                set.add(a[j-1]);
                            }
                        }
                        res[i]=set.size();
                    }
                }
                for(int i=0;i<m;i++){
                    if(i!=m-1){
                        System.out.print(res[i]+" ");
                    }
                    else{
                        System.out.print(res[i]);
                    }
                }



            }
        }
    }
