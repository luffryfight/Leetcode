package cn.kobe;

import java.util.Arrays;

/**
 * 作用：像优化一下结果发现差不多
 * 2020/10/24
 */
public class Solution3 {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        int[] limits = new int[T + 1];
        Arrays.fill(limits, 0);
        for (int[] ch : clips) {//获取极限
            int start = ch[0], end = ch[1];
            limits[start] = Math.max(limits[start], end);
        }
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
}
