package cn.kobe;

public class Solution {
    //类似的题有编辑距离和538两个字符串的删除操作
    //求最长公共的字串的数值，然后s1+s2的和-2*公共
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        //转换成数组
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        //定义dp
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1[i - 1] == str2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + str1[i - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += str1[i];
        }
        for (int i = 0; i < n; i++) {
            sum += str2[i];
        }
        return sum - 2 * dp[m][n];
    }
}
