public class Solution2 {
    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int number=nums[0];
        int count=0;
        for(int num:nums){
            if(count==0){
                number=num;
                count=1;
            }
           else if(num==number)
                ++count;
            else
                --count;
        }
        return number;
    }
}
