package cn.kobe;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
             val = x;
             next = null;
        }
    }
    //方法一: 暴力法
    //方法二: 哈希表法 √
    //方法三：双指针法:太巧妙了真的6
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode pa=headA,pb=headB;
        while (pa!=pb){
            pa= pa==null?headB:pa.next;
            pb= pb==null?headA:pb.next;
        }
        return pa;
    }
}
