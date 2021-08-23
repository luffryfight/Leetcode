package cn.kobe;

import java.util.Arrays;

/**
 * 作用：//可能会存在负数的情况
 * 如果全是正数，则最后三个数相乘
 * 如果有两个负数，可能就是最后最小的两个负数相乘再乘最大的正数
 * 2021/1/20
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
    }
}
