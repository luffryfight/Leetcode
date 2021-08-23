public class Solution {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);//+1不能再外面
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
