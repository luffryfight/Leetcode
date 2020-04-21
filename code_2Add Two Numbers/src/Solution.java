class Solution {
        public static void main(String[] args) {
            ListNode l1=new ListNode(5);
            /*l1.next=new ListNode(4);
            l1.next.next=new ListNode(3);*/
            ListNode l2=new ListNode(5);
           /* l2.next=new ListNode(6);
            l2.next.next=new ListNode(4);*/

            ListNode res= addTwoNumbers(l1,l2);
            for (int i = 0; i < 3; i++) {
                System.out.println(res.val);
                res=res.next;
            }

        }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list= new ListNode(0);
        ListNode lp=list;
        int temp=0;//保存值
        for(;l1!=null||l2!=null||temp!=0;){
                if(l1!=null){
                    temp+=l1.val;
                    l1=l1.next;
                }
                if(l2!=null){
                temp+=l2.val;
                l2=l2.next;
                }
                list.next=new ListNode(temp%10);
                temp/=10;
                list=list.next;
        }
        return lp.next;
    }


}
