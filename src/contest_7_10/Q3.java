package contest_7_10;

import java.util.Stack;

public class Q3 {
    public boolean canChange(String start, String target) {
        int n=start.length();
        int index=0;
        for(int i=0;i<n;i++){
            if(target.charAt(i)=='L'){
                while (index < n && start.charAt(index)!='R') {
                    index++;
                    if(start.charAt(index)=='L'){
                        break;
                    }
                }
                if(index<n&&start.charAt(index)=='L'){
                    continue;
                }else {
                    return false;
                }
            }
        }
        index=n-1;
        for(int i=n-1;i>=0;i--){
            if(target.charAt(i)=='R'){
                while (index >=0 && start.charAt(index)!='L') {
                    if(start.charAt(index)=='L'){
                        break;
                    }
                    index--;
                }
                if(index >=0&&start.charAt(index)=='L'){
                    index--;
                    continue;
                }else {
                    return false;
                }
            }
        }

        return true;
    }



    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<asteroids.length;i++){
            //如果栈空
            if(stack.isEmpty()){
                stack.add(asteroids[i]);
            }
            //如果同号
            if((stack.peek()>0&&asteroids[i]>0)||(stack.peek()<0&&asteroids[i]<0)){
                stack.add(asteroids[i]);
            }
            //如果异号
            else{
                while(!stack.isEmpty()&&Math.abs(stack.peek())<Math.abs(asteroids[i])){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.add(asteroids[i]);
                }else if(stack.peek()==asteroids[i]){
                    stack.pop();
                    continue;
                }else{
                    continue;
                }

            }

        }
        if(stack.isEmpty()){
            return new int[]{};
        }
        int[] res=new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            res[i]=stack.pop();
        }
        return res;
    }
}
