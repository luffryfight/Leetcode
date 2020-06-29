package cn.kobe;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;


public class Solution2 {

    public static int findKthLargest(int[] nums, int k) {
        MinStack2 ms=new MinStack2();
        for(int num:nums){
            ms.push(num);
        }
        for (int i= nums.length-k;i>=0;i--){
            ms.pop();
        }
        return ms.top();
    }

    public static void main(String[] args) {
        int []nums={3,2,3,1,2,4,5,5,6};
        System.out.println(Solution2.findKthLargest(nums,6));
    }

}
class MinStack2 {
    class Node{
        int x;
        int min;
        Node next;
        public Node(int x, int min) {
            this.x = x;
            this.min = min;
            next=null;
        }
    }
    Node head;
    public void push(int x) {
        if(head==null){
            head=new Node(x,x);
        }else{
            Node temp=new Node(x,Math.min(x,head.min));
            temp.next=head;
            head=temp;
        }
    }
    public void pop() {
        if(head!=null){
            head=head.next;
        }
    }
    public int top() {
        if(head!=null){
            return head.x;
        }
        return -1;
    }
    public int getMin() {
        if(head!=null){//不为空
            return head.min;
        }
        return -1;
    }
}
