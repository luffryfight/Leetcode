public class Solution2 {//内存优化
    public static int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target) {
                left=mid;
                right=mid;
                while (left > 0 && nums[left - 1] == target) left--;
                while (right < nums.length-1 && nums[right + 1] == target) right++;
                return new int[]{left, right};
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}
