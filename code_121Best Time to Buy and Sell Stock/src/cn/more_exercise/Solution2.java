package cn.more_exercise;

import sun.nio.cs.ext.MacHebrew;

public class Solution2 {
    public int maxProfit(int prices[]) {
        if (prices.length <= 1) return 0;
        int min = prices[0];
        int res = 0;
        for (int temp : prices) {
            if (min > temp) {
                min = temp;
            } else {
                res = Math.max(res, temp - min);
            }
        }
        return res;
    }
}
