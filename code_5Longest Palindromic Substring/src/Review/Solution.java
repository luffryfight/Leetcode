package Review;

/**
 * 作用：
 * 2021/1/26
 */
public class Solution {
    //状态方程：看下面的for
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1, index = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (str[i] != str[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {//同一个或者相邻两个相同
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    index = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(index, index + maxLen);
    }
}
