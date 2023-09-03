package contest_7_10;

import java.util.*;

class Q2 {
    Set<Integer> set;
    public Q2() {
        set=new HashSet<>();
    }

    public int popSmallest() {
        if(set.isEmpty()){
            set.add(1);
            return 1;
        }
       for(int i=1;i<=set.size()+1;i++) {
           if (!set.contains(i)) {
               set.add(i);
               return i;
           }
       }
       return 0;
    }

    public void addBack(int num) {
        if(set.contains(num)){
            set.remove(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */