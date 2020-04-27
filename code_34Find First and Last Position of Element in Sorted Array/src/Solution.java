public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target) {
                int l = mid;
                while (l > 0 && nums[l - 1] == target) l--;
                int r = mid;
                while (r < right && nums[r + 1] == target) r++;
                return new int[]{l, r};
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}
