import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ListNode<T> {
    public T data;
    public ListNode next;
}

class Solution {
    public void print(ListNode<Integer> head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ->");
            temp=temp.next;
        }
        System.out.println();
    }
    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        if(left==right){
            return head;
        }
        if(left==1){
            ListNode q=head;
            for(int i=left;i<right;i++){
                q=q.next;
            }
            ListNode tt=q;
            q=q.next;
            tt.next=null;
            ListNode<Integer> temp=ReverseList(head);
            ListNode p=temp;

            while(p.next!=null){
                p=p.next;
            }
            p.next=q;
            return temp;
        }

        ListNode p=head;
        ListNode q=head;
        for(int i=0;i<left-2;i++){
            p=p.next;
            q=q.next;
        }
        //System.out.println(q.data);
        for(int i=left;i<=right;i++){
            q=q.next;
            //System.out.println(q.data);
        }
        ListNode tt=q;
        q=q.next;
        tt.next=null;


        //print(p);
        //print(q);
        ListNode<Integer> temp=ReverseList(p.next);
        p.next=temp;

        while(p.next!=null){
            p=p.next;
        }
        p.next=q;
        return head;
    }
    public ListNode ReverseList(ListNode<Integer> head){
        ListNode reverse=head;
        ListNode prev=null;
        while(reverse!=null){
            ListNode temp=reverse.next;
            reverse.next=prev;
            prev=reverse;
            reverse=temp;

        }
        return prev;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode<Integer> res = null;

        int head_size = 0;
        head_size = in.nextInt();
        ListNode<Integer> head = null, head_curr = null;
        for(int head_i = 0; head_i < head_size; head_i++) {
            int head_item = in.nextInt();
            ListNode<Integer> head_temp = new ListNode<Integer>();
            head_temp.data = head_item;
            head_temp.next = null;

            if (head == null) {
                head = head_curr = head_temp;
            } else {
                head_curr.next = head_temp;
                head_curr = head_temp;
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int left;
        left = Integer.parseInt(in.nextLine().trim());

        int right;
        right = Integer.parseInt(in.nextLine().trim());

        res = new Solution().reverseBetween(head, left, right);
        while (res != null) {
            System.out.print(String.valueOf(res.data) + " ");
            res = res.next;
        }
        System.out.println();

    }
}