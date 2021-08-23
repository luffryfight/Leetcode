/**
 * 作用：面试复习
 * 2021/1/20
 */
public class Review {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(-1);
        ListNode list=new ListNode(-1);
        int carry=0;
        res=list;
        while(l1!=null&&l2!=null){
            int num=l1.val+l2.val+carry;
            carry=num/10;
            num%=10;
            l1=l1.next;
            l2=l2.next;
            ListNode node=new ListNode(num);
            list.next=node;
            list=list.next;
        }
        while(l1!=null){//同上
            int num=l1.val+carry;
            carry=num/10;
            num%=10;
            l1=l1.next;
            ListNode node=new ListNode(num);
            list.next=node;
            list=list.next;
        }
        while(l2!=null){//同上
            int num=l2.val+carry;
            carry=num/10;
            num%=10;
            l2=l2.next;
            ListNode node=new ListNode(num);
            list.next=node;
            list=list.next;
        }
        if(carry!=0){
            ListNode node=new ListNode(carry);
            list.next=node;
        }
        return res.next;
    }*/
    //太冗余了
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(-1);
        ListNode temp = list;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return list.next;
    }
}
