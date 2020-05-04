public class Solution {
    public static int findMin(int[] nums) {
        int left=0;
        int len=nums.length-1;
        int right=len;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]<nums[len]){//在小的部分
                right=mid;
            }else {
                left=mid+ 1;
            }
        }
        return nums[left];
    }
}
