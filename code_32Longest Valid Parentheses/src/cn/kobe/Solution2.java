package cn.kobe;

public class Solution2 {
    //dp 主要是递推关系
    public int longestValidParentheses(String s) {
       int max=0;
       int[] dp=new int[s.length()];
       //转成字符串
       char[] str=s.toCharArray();
        for (int i = 1; i < str.length; i++) {
            if(str[i]==')'){
                if(str[i-1]=='('){
                    dp[i]= (i>=2?dp[i-2]:0)+2;
                }else if(i-dp[i-1]>0&&str[i-dp[i-1]-1]=='('){
                    dp[i]=dp[i-1] + (i-dp[i-1]>=2?dp[i-dp[i-2]-2]:0) + 2;
                }
                max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
}