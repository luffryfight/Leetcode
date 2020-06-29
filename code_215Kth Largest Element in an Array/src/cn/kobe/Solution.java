package cn.kobe;

import java.util.Arrays;

public class Solution {
    /*
    * 6.29打卡题，排序，堆！队列，
    * */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
