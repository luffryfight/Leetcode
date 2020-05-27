package cn.none;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len<=1) return len;

        //使用双指针
        int j=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]!=nums[j]){//类似插入排序的过程
                nums[++j]=nums[i];
            }
        }
        return j+1;
    }
}
