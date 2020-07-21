package cn.kobe;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**注意注意 以后遇到链表栈都可以用数组来做，可以先遍历一边保存在数组中，也可以直接遍历时保存**/
public class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
  ListNode heada=null;
    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list= new LinkedList<>();
        Deque<Integer> stack=new ArrayDeque<>();
        int i=0;list.add(0);
        ListNode p=head;
        while(p!=null){
            while(!stack.isEmpty()&&getone(stack.peek(),head)<p.val){
                list.set(stack.peek(),p.val);
                stack.pop();
            }
            stack.push(i);
            p=p.next;i++;
        }
        int size=stack.size();
        while(size-->0){
            list.add(0);
        }
        int[] res=new int[list.size()];
        int index=0;
        for(Object ch:list.toArray()){
            res[index]=list.get(index);index++;
        }
        return  res;
    }
    private static int getone(int index,ListNode head){
        ListNode p=head;
        while(index-->0){
            p=p.next;
        }
        return p.val;
    }
    private void addone(int num){
        ListNode newnode=new ListNode(num);
        ListNode p=heada;
        if(null==heada){
            heada=newnode;
        }else {
            while(p.next!=null){
                p=p.next;
            }
            p.next=newnode;
        }
    }

    public static void main(String[] args) {
        Solution so=new Solution();
        int[]arr={2,7,4,3,5};
        for(int ch:arr){
            so.addone(ch);
        }
        System.out.println(Solution.nextLargerNodes(so.heada));
    }
}
