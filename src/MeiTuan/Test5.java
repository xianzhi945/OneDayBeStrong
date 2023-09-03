    package MeiTuan;

    import java.util.*;

    public class Test5 {
        public static void main(String args[]){
            Scanner reader=new Scanner(System.in);
            while(reader.hasNextInt()){

                int n=reader.nextInt();
                int m=reader.nextInt();
                int[][] a=new int[m][2];
                Map<Integer, List<Integer>> map=new HashMap<>();
                for(int i=0;i<m;i++){
                    a[i][0]=reader.nextInt();
                    a[i][1]=reader.nextInt();
                    List<Integer> list=map.getOrDefault(a[i][1],new ArrayList<>());
                    list.add(a[i][0]);
                    map.put(a[i][1],list);
                }

                int res=0;



                System.out.println(res);

            }
        }
    }
