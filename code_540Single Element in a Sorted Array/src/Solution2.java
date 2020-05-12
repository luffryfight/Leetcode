public class Solution2 {
    /*
    * 二分的判断条件是：nums[mid（奇）]
    * 满足nums[mid]==mid[mid+1]则前半部分没有单独的
    * */
    public int singleNonDuplicate(int[] nums){
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid=(l+r)>>1;
            if((mid&1)==1){
                --mid;
            }
            if(nums[mid]==nums[mid+1]){
                l=mid+2;
            }else{
                r=mid;
            }
        }
        return nums[l];
    }
}
