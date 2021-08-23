package cn.kobe;

public class Solution {
    //状态关系f(k)=f(k-1)+f(k-3)+f(k-5)
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int ch : nums) {
                if (ch <= i)
                    dp[i] += dp[i - ch];
            }
        }
        return dp[target];
    }
}
