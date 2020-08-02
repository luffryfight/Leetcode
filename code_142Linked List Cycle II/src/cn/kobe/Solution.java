package cn.kobe;




import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //题目要求是返回节点
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        //存入每个节点，当节点重复时就是环
        Set<ListNode> set=new HashSet<>();

        ListNode temp=head;
        //一遍遍历
        while(temp!=null){
            if(set.contains(temp))
                return temp;
            set.add(temp);
            temp=temp.next;
        }

        return null;
    }
}
