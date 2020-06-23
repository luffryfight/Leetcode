package cn.kobe;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len<=1) return len;

        //使用双指针
        int j=0;
        for(int num:nums){
            if(j<2||num!=nums[j-2]){
                nums[j++]=num;
            }
        }
        return j;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
