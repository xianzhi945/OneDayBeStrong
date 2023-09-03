import java.util.HashMap;

public class LRU<K,V> {
    private class Node{
        Node pre;
        Node next;
        K k;
        V v;
    }
    private int cap;
    private Node head;
    private Node tail;
    private HashMap<K,Node> map;
    private LRU(int cap){
        this.cap=cap;
        map=new HashMap<>(cap+1);
    }

    public void moveToTail(Node node){
        if(node==tail) {
            return;
        }else if(node==head){
            head.next.pre=null;
            head=head.next;
        }else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        tail.next=node;
        node.next=null;
        node.pre=tail;
        tail=node;
    }
    public void put(K k,V v){
        Node node = map.get(k);
        if(node!=null){
            node.v=v;
            moveToTail(node);
            map.put(k,node);
            return;
        }
        node=new Node();
        node.k=k;
        node.v=v;
        map.put(k,node);
        if(head==null&&tail==null){
            head=node;
            tail=node;
        }else {
            node.pre=tail;
            tail.next = node;
            tail = node;
        }
        if(map.size()>cap){
            map.remove(head.k);
            head=head.next;
            head.pre=null;
        }
    }
    public V get(K k){
        if(!map.containsKey(k)){
            return null;
        }
        //将该节点移动到头部
        Node p=map.get(k);
        moveToTail(p);
        return p.v;
    }
    public void print(){
        Node p=tail;
        while(p!=null){
            System.out.println(p.k+" "+p.v);
            p=p.pre;
        }
        System.out.println();
    }
    public void print2(){
        Node p=head;
        while(p!=null){
            System.out.println(p.k+" "+p.v);
            p=p.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LRU<String,String> lru=new LRU<>(2);
        lru.put("1","1");
        lru.print();

        lru.put("2","2");
        lru.print();
        lru.get("1");
        lru.print();
        lru.put("3","3");
        lru.print();
        lru.get("2");
        lru.print();
        lru.put("4","4");
        lru.get("1");
        lru.print();
        lru.get("3");
        lru.print();
        lru.get("4");
        lru.print();
        StringBuilder sb=new StringBuilder();

    }

}



