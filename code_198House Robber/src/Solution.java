public class Solution {
    public static int rob(int[] nums) {
        if(nums.length<=0) {
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        if(nums[0]>nums[1]){
            nums[1]=nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            nums[i]=Math.max(nums[i-1],nums[i-2]+nums[i]);
        }
        return nums[nums.length-1];
    }
}