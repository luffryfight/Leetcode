package cn.kobe;

public class Solution3 {
    //这个更快的原因是，它少调用了二个递归函数，省去了很多调用函数的时间
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newList = mergeSortListNode(head);

        return newList;
    }

    public ListNode mergeSortListNode(ListNode firstNode) {

        if (firstNode.next == null) {
            return firstNode;
        }
        // 找到一个节点的位置

        // 计算中间节点，进行递归
        ListNode midNode = findMidNode(firstNode);
        ListNode secondNode = midNode.next;
        // 把列表切断成两部分！
        midNode.next = null;

        ListNode head1 = mergeSortListNode(firstNode);
        ListNode head2 = mergeSortListNode(secondNode);
        ListNode ptr1 = head1;
        ListNode ptr2 = head2;

        /**
         * 咱们在进行合并的时候不是会遇上链表连接？那就解决这个问题，在查找中点的时候把他cut断就好啦！！！
         */
        ListNode newHead;
        ListNode ptrCur;
        if (ptr1.val < ptr2.val) {
            newHead = ptr1;
            ptr1 = ptr1.next;
        } else {
            newHead = ptr2;
            ptr2 = ptr2.next;
        }
        ptrCur = newHead;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                ptrCur.next = ptr1;
                ptr1 = ptr1.next;

            } else {
                ptrCur.next = ptr2;
                ptr2 = ptr2.next;
            }
            ptrCur = ptrCur.next;
        }

        if (ptr1 != null) {
            ptrCur.next = ptr1;
            ptr1 = ptr1.next;
        }

        if (ptr2 != null) {
            ptrCur.next = ptr2;
            ptr2 = ptr2.next;
        }

        return newHead;
    }

    public ListNode findMidNode(ListNode firstNode) {
        /**
         * 找中点，快慢指针！
         */
        ListNode ptr = firstNode;
        ListNode fastPtr = firstNode;

        while (fastPtr != null && fastPtr.next != null && fastPtr.next.next != null) {
            ptr = ptr.next;
            fastPtr = fastPtr.next.next;
        }

        return ptr;
    }
}
