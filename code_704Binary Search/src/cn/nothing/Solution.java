package cn.nothing;

public class Solution {
    /*
    * 最简单的二分了。。。
    * */
    public int search(int[] nums, int target) {
        int l=0,r=nums.length;
        while(l<r){
            int mid=(l+r)>>1;
            if(nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return -1;
    }
}
