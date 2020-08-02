package cn.kobe;

public class Solution {
    //2020-7.31打卡题,就这？？

    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==i)
                return i;
        }
        return -1;
    }
}
