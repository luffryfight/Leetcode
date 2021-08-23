package cn;

public class Solution {
    public int findLength(int[] A, int[] B) {
        int len1 = A.length, len2 = B.length;
        //定义dp数组
        int[][] dp = new int[len1 + 1][len2 + 1];
        int res = 0;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (A[i - 1] == B[j - 1]) {//递归关系
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 0;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }

        }
        return res;
    }
}
