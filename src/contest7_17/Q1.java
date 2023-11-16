package contest7_17;


import java.util.*;

public class Q1 {
    class TrieNode{
        int val=0;
        List<Integer> list=new ArrayList<>();
        TrieNode[] children=new TrieNode[10];
    }
    TrieNode root;
    public void insert(String nums,int index){
        TrieNode p=root;
        for(char c:nums.toCharArray()) {
            int i = c - '0';
            if (p.children[i] == null) {
                p.children[i] = new TrieNode();
            }
            p = p.children[i];
            p.val++;
            p.list.add(index);
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res=new int[queries.length];
        int numLength=nums[0].length();

//        Arrays.sort(queries, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }
//        });
//        for(int i=0;i<queries.length;i++){
//            System.out.println(queries[i][1]);
//        }
        for(int i=0;i<queries.length;){
            int left=numLength-queries[i][1];
            String[][] temp=new String[nums.length][2];
            for(int m=0;m<nums.length;m++){
                temp[m][0]=nums[m].substring(left,numLength);
                temp[m][1]=String.valueOf(m);
            }

            Arrays.sort(temp, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return o1[0].compareTo(o2[0]);
                }
            });
            int j=i;
            while(j<queries.length&&queries[j][1]==queries[i][1]){
                res[j]=Integer.parseInt(temp[queries[j][0]-1][1]);
                j++;
            }
            i=j;
        }
        return res;
    }
    public static void main(String[] args) {
        String a="01";
        String[] aa=new String[]{"102","473","251","814"};
        int[][] temp=new int[][]{{1,1},{2,3},{4,2},{1,2}};

        Q1 q1=new Q1();
        int[] res=q1.smallestTrimmedNumbers(aa,temp);
        System.out.println(res.length);


        System.out.println(Long.parseLong("4333639502"));

        double aaaa=630016464;
        System.out.println((double)aaaa/8);


        int n=749556028;
        Set<Integer> yin=new HashSet<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                yin.add(i);
                if(n != i*i){
                    yin.add(n/i);
                }
            }
        }
        System.out.println(yin.size()+" "+yin.contains(284929384));
//        for(int i:yin){
//            System.out.println(i);
//        }
        System.out.println();
    }
}
