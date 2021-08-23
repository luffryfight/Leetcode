package cn.kobe;

import java.util.Arrays;

public class Solution2 {
    /*
     * 本题使用动态规划，重点是如何叠加(再加一次)之前加过的
     * */
    public static int maxSatisfaction(int[] satisfaction) {
        if (satisfaction.length <= 0) return 0;
        int len = satisfaction.length;
        //先排序
        Arrays.sort(satisfaction);
        if (satisfaction[len - 1] <= 0) return 0;

        int res = 0, sum = 0, total = 0;
        for (int i = len - 1; i >= 0; i--) {
            total += sum + satisfaction[i];//再加一次前面的总和，再加当前元素
            res = Math.max(res, total);
            sum += satisfaction[i];//计算前一位所有和
        }
        return res;
    }
}
