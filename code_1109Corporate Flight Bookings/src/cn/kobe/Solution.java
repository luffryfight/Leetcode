package cn.kobe;

/**
 * 作用：正常思路  1000ms+
 * 2020/10/14
 */
public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] ch : bookings) {
            int i = ch[0], j = ch[1], num = ch[2];
            for (int k = i; k <= j; k++) {
                res[k - 1] += num;
            }
        }
        return res;
    }
}
