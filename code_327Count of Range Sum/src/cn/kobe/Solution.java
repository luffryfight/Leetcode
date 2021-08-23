package cn.kobe;

import javax.print.attribute.standard.NumberUp;

/**
 * 作用：暴力法，需要注意特殊情况，
 * 然后慢慢改进
 * 2020/11/7
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= lower && sum <= upper)
                res++;
            for (int j = i - 1; j >= 0; j--) {
                sum += nums[j];
                if (nums[i] == nums[j] &&//注意最大数和最小数相加的特殊情况
                        (nums[i] == -2147483647 || nums[i] == Integer.MAX_VALUE))
                    continue;
                if (sum >= lower && sum <= upper)
                    res++;
            }
            sum = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-2, 5, -1, 5, 2, 3, 8, 0, 1, 2, -2};
        System.out.println(solution.countRangeSum(arr, -564, 3864));
        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
        //System.out.println(Integer.toBinaryString(2147483647));
    }
}
