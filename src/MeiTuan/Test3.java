    package MeiTuan;

    import java.util.Arrays;
    import java.util.HashSet;
    import java.util.Scanner;
    import java.util.Set;

    public class Test3 {
        public static void main(String args[]){
            Scanner reader=new Scanner(System.in);
            while(reader.hasNextInt()){
                int m=reader.nextInt();
                int sum=0;
                int[] a=new int[m];
                for(int i=0;i<m;i++){
                    a[i]=reader.nextInt();
                    sum+=a[i];
                }
                Arrays.sort(a);
                int res=0;
                for(int i=0;i<m;i++){
                    res+=sum/a[i];
                    sum=sum-a[i];

                }
                System.out.println(res);





            }
        }
    }
