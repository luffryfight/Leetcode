package cn.kobe;

class Solution {
    //看的题解！。。。果然还是个dp菜鸟
    //可以说很清楚了额
    int[][][] dp = new int[105][105][105];

    public int removeBoxes(int[] a) {
        int n = a.length;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = Math.max(dp[i][j][k], (j - 1 < i ? 0 : dp[i][j - 1][0]) + (k + 1) * (k + 1));
                    for (int t = i; t <= j - 1; t++) {
                        if (a[t] == a[j]) {
                            dp[i][j][k] = Math.max(dp[i][j][k], (t + 1 > j - 1 ? 0 : dp[t + 1][j - 1][0]) +
                                    dp[i][t][k + 1]);
                        }
                    }
                }
            }
        }
        return dp[0][n - 1][0];
    }
}