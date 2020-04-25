public class Solution {
    public static boolean canJump(int[] nums) {
        int maxpos=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(i>maxpos){
                return false;
            }
            maxpos=Math.max(maxpos,nums[i]+i);
        }
        return true;
    }
}
