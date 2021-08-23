package cn.kobe;

public class Solution {
    /*
     * 说是动态规划，但是更像数学题
     * */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++)//G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
                dp[i] += dp[i - j] * dp[j - 1];
        }
        return dp[n];
    }
}
