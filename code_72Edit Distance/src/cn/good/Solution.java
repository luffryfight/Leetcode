package cn.good;

public class Solution {
    /*
     * 求解需要用到子序列的结果，故用动态规划
     * 注意i=0和j=0时的结果
     * 这道题是看别人的题解。。。
     * */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //定义二维数组
        int[][] dp = new int[len1 + 1][len2 + 1];

        //取len+1是因为下面取得x-1并且当i=len-1时还要遍历w2计算dp
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + min_3(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                    }
                }
            }
        }
        return dp[len1][len2];
    }

    private int min_3(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }
}
