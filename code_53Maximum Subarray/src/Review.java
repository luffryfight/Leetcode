/**
 * to do : 但是题目还有进阶：要求用分治
 *
 * @author 86137
 * @date 2021/4/24 16:14
 */
public class Review {
    class Solution {
        public int maxSubArray(int[] nums) {
            int res = Integer.MIN_VALUE, dp = 0;
            for (int i = 0; i < nums.length; i++) {
                dp += nums[i];
                res = Math.max(res, dp);
                dp = dp < 0 ? 0 : dp;

            }
            return res;
        }
    }
}
