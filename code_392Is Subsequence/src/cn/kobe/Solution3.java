package cn.kobe;

public class Solution3 {
    //动态规划
    //定义 到dp[i][j]时是否包含
    public boolean isSubsequence(String s, String t) {
        int len = t.length();
        boolean[][] dp = new boolean[len + 1][t.length() + 1];
        //转换成数组
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        //base case
        for (int i = 0; i < str2.length; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (str1[i] == str2[j])
                    dp[i][j] = dp[i - 1][j - 1];
                else//看之前是否包含了
                    dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[len][t.length()];
    }
}
