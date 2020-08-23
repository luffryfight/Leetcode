package cn.kobe;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    public int numComponents(ListNode head, int[] G) {
        //把元素放入桶中，题目说了不会重复
        Set<Integer> buckets=new HashSet<>();
        for(int ch:G)
            buckets.add(ch);
        int count=0;
        while (head!=null){
            if(buckets.contains(head.val)&&
                    (head.next==null||!buckets.contains(head.next.val)))
                count++;
            head=head.next;
        }
        return count++;
    }
}
