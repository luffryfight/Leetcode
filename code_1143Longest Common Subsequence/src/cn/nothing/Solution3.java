package cn.nothing;

public class Solution3 {
    /*
     * 定义dp[i]为t[j]从s[i]到s[row-1]的最大值
     * */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) return 0;
        int row = text1.length(), cul = text2.length();
        //转换为数组
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        //定义dp数组,提高读取效率
        int[] dp = new int[cul + 1];//初始化为0

        for (int i = 1; i <= row; i++) {
            int temp = 0;//注意这里=0有多细节,如果是第一次就相同，就是0+1；和j==1->0+1 一样
            for (int j = 1; j <= cul; j++) {
                int dp_temp = 0;
                if (str1[i - 1] == str2[j - 1]) {
                    dp_temp = temp + 1;
                } else {
                    dp_temp = Math.max(dp[j], dp[j - 1]);
                }
                temp = dp[j];//temp其实表示的是dp[j-1]（上一个dp）
                dp[j] = dp_temp;
            }
        }
        return dp[cul];
    }
}
