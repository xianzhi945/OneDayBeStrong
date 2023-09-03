    package MeiTuan;

    import java.util.Arrays;
    import java.util.HashSet;
    import java.util.Scanner;
    import java.util.Set;

    public class Test4 {
        public static void main(String args[]){
            Scanner reader=new Scanner(System.in);
            while(reader.hasNextInt()){
                int m=reader.nextInt();
                int n=reader.nextInt();
                int[] a=new int[m];
                for(int i=0;i<m;i++){
                    a[i]=reader.nextInt();

                }

                int res=0;


                Set<Integer> set=new HashSet<>();

                for(int i=0;i<m;i++){
                    set.clear();
                    set.add(a[i]);
                    res++;

                    for(int j=1+i;j<m;j++){

                        Object[] temp=set.toArray();
                        for(Object num:temp){
                            //System.out.println(num+" "+a[j]+" "+((int)num^a[j]));
                            set.add((int)num^a[j]);
                        }
                        set.add(a[j]);
                        set.remove(0);
                        //System.out.println(set.size());
                        if(set.size()<=n){
                            res++;
                        }else{
                            break;
                        }
                    }
                }

                System.out.println(res);





            }
        }
    }
