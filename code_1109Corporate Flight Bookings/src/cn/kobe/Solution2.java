package cn.kobe;

/**
 * 作用：使用差分数组的方法  3ms
 * 2020/10/14
 */
public class Solution2 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //10 45 -10 -20  -25
        int[] res = new int[n];
        int[] pre = new int[n + 1];
        for (int[] ch : bookings) {
            int i = ch[0], j = ch[1], num = ch[2];
            pre[i - 1] += num;
            if (j < n) pre[j] -= num;
        }
        res[0] = pre[0];
        for (int i = 1; i < n; i++) {
            res[i] = pre[i] + res[i - 1];
        }
        return res;
    }
}
