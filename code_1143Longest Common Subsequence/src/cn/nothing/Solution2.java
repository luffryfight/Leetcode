package cn.nothing;

public class Solution2 {
    /*
    * 动态规划：定义F(i,j)表述s[0,i)和t[0,j)的最长子序列
    *                 |F(i-1,j-1)  s[i-1]==t[j-1]
    * 关系式: F（i,j）= |
    *                 |max(F(i,j-1),F(i-1,j))   s[i-1]!=t[j-1]
    *
    * base case: F(i,0)=0
    *            F(0,j)=0
    *
    * 空间优化：见Solution3
    * */
    public int longestCommonSubsequence(String text1, String text2){
        if(text1.isEmpty()||text2.isEmpty()) return 0;
        int row=text1.length(),cul=text2.length();
        //转换为数组
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        //定义dp数组,提高读取效率
        int[][] dp=new int[row+1][cul+1];

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= cul; j++) {
                if(i==0||j==0){
                    dp[i][j]=0;
                }else{
                    if(str1[i-1]== str2[j-1]){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[row][cul];
    }
    /*
    * 比较718题：最长公共子数组！
    * */
}
