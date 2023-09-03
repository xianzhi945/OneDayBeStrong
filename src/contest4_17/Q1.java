package contest4_17;

public class Q1 {
    public String digitSum(String s, int k) {
        if(s.length()<=k){
            return s;
        }
        while(true){
            StringBuilder sb=new StringBuilder();
            int left=0;
            int right=k;

            while(left<s.length()){
                //int a=Integer.parseInt(s.substring(left,right));
                int temp=0;
                for(int i=left;i<right;i++){
                    temp+=s.charAt(i)-'0';
                }
                left=right;
                right=Math.min(s.length(),right+k);
                sb.append(temp);
                //System.out.println(left+" "+right+" "+temp);
            }
            s=sb.toString();
            if(sb.toString().length()<=k){
                return sb.toString();
            }
        }
    }
    public static void main(String[] args) {
        Q1 q1=new Q1();
        System.out.println(q1.digitSum("233",3));
    }
}
