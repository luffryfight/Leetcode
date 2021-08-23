package cn.kobe;

public class Solution {
    //定义dp[i][j] 戳破i,j之间能获得的最高分，
    //base case:假定j的索引比i大
    // j<<i,i[0,n+1]：   dp[i][j]=0;
    //else case:
    // dp[i][j]=Math.max(dp[i][j],sum)
    //同时设定k为最后一个戳破的数，dp[i][j]等于最后戳破的这个气球+左右两边的dp
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newnums = new int[n + 2];
        newnums[0] = newnums[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            newnums[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {//遍历获得dp[i][j]的最大值
                    int sum = newnums[i] * newnums[j] * newnums[k] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n + 1];
    }
}
