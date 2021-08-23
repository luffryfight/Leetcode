package cn.kobe;

import java.util.Map;

public class Solution {
    //某个元素只能来自左边或者上边，即可以得到状态转移方程
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = grid[i - 1][j - 1] + dp[i][j - 1];
                } else if (j == 1) {
                    dp[i][j] = grid[i - 1][j - 1] + dp[i - 1][j];
                } else
                    dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(Solution2.minPathSum(arr));
    }
}
