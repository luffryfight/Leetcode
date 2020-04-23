public class Solution2 {
    public static int maxSubArray(int[] nums) {
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[0]<0){
                nums[0]=nums[i];
            }else{
                nums[0]+=nums[i];
            }
            max=Math.max(max,nums[0]);
        }
        return max;
    }
}
