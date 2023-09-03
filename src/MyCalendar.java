import java.util.TreeMap;

class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map=new TreeMap<>();
        map.put(-1,-1);

        map.put((int)1e9+1,(int)1e9+1);
    }

    public boolean book(int start, int end) {
        Integer a=map.ceilingKey(start);//右边
        Integer b=map.floorKey(start);//左边
        if(a<end||map.get(b)>start){return false;}
        map.put(start,end);
        return true;
    }
}