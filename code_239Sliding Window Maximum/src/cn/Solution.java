package cn;

import java.util.ArrayList;

public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {//特殊情况
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int l = 0, r = 0;
        int index = 0;
        int max = nums[0];
        int premax = -10000;
        int preind = 0;//索引的目的是判断max是否出界
        int count = 0;
        while (r < nums.length) {
            if (r - l < k - 1) {//先移动r到正确位置
                r++;
                if (nums[r] > max) {
                    index = r;
                    max = nums[r];
                }
                if (premax <= nums[r] && nums[r] < max) {//获取前K个中第二小的，并保存其索引
                    premax = nums[r];
                    preind = r;
                }
            } else {
                res[count++] = max;
                l++;
                r++;
                if (r < nums.length && (premax < nums[r] || r - preind > k - 2)) {
                    premax = nums[r];
                    preind = r;
                }
                if (index < l || max < premax) {
                    max = premax;
                    index = preind;
                }
            }
        }
        preind = Integer.MAX_VALUE;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        Solution3 solu;
        nums = Solution.maxSlidingWindow(nums, 5);
        System.out.println(nums);
    }
}
