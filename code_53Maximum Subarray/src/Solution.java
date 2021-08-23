public class Solution {
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (dp[0] < dp[i]) {
                dp[0] = dp[i];
            }
        }
        return dp[0];
    }
}
/*
执行用时 :1 ms, 在所有 Java 提交中击败了96.38%的用户
内存消耗 :39.8 MB, 在所有 Java 提交中击败了38.20%的用户
*/