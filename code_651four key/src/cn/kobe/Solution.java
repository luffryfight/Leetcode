package cn.kobe;

public class Solution {
    /*
    * 定义：dp[i]是第几步时最优的结果
    *
    * dp[i]=[2--i)的最优 dp[i-2]*(i-j+1) 选中后，复制，然后连续粘贴(i-j+1)次
    *
    * base case:dp[i]=i;
    * */
    public int manA(int N){
        int[] dp=new int[N+1];
        for (int i = 1; i < N; i++) {
            dp[i]=dp[i-i]+1;
            for(int j=2;j<i;j++){//这一步类似上一题Leetcode300
                dp[i]=Math.max(dp[i],dp[i-2]*(i-j+1));
            }
        }
        return dp[N];
    }
}
