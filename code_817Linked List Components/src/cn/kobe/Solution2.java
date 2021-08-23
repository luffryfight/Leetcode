package cn.kobe;

public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //如果自己实现Set集合会更快一些
    public int numComponents(ListNode head, int[] G) {
        final int N = Len(head);
        boolean[] mark = new boolean[N];
        for (int component : G) {
            if (component >= N) continue;
            mark[component] = true;
        }

        int out = 0;
        ListNode p = head, n = null;
        while (p != null) {
            n = p;
            while (n != null && mark[n.val])
                n = n.next;
            if (n == p) p = p.next;
            else {
                ++out;
                p = n;
            }
        }
        return out;
    }

    private int Len(ListNode head) {
        int out = 0;
        while (head != null) {
            ++out;
            head = head.next;
        }
        return out;
    }
}
