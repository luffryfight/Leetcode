public class Solution {
    public static boolean canJump(int[] nums) {
        int maxpos = nums[0];//能够到达的最大位置
        for (int i = 0; i < nums.length; i++) {
            if (i > maxpos) {//当前位置超过能到达的最大位置
                return false;
            }
            maxpos = Math.max(maxpos, nums[i] + i);
        }
        return true;
    }
}
