package cn.kobe;

class Solution2 {
    /**/
    public int minimumDeleteSum(String s1, String s2) {
        /*
            当 s1[i] == s2[j]，dp[i][j] = dp[i-1][j-1];
            当 s1[i] != s2[j]，dp[i][j] = Math.min(dp[i-1][j-1] + s1[i] + s2[j],
            Math.min(dp[i][j-1] + s2[j],dp[i-1][j] + s1[i]));
        */
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    dp[i][j] = s2.charAt(j - 1) + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = s1.charAt(i - 1) + dp[i - 1][j];
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + s1.charAt(i - 1) + s2.charAt(j - 1), Math.min(dp[i][j - 1] + s2.charAt(j - 1), dp[i - 1][j] + s1.charAt(i - 1)));
                    }
                }
            }
        }
        return dp[len1][len2];
    }
}
