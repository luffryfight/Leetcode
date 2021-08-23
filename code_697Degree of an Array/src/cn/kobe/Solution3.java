package cn.kobe;

/**
 * to do :大神的题解，没仔细看，用数组代替map
 * 分析链接
 * https://leetcode-cn.com/problems/degree-of-an-array/solution/xiang-xi-fen-xi-ti-yi-yu-si-lu-jian-ji-d-nvdy/
 *
 * @author 86137
 * @date 2021/2/20 15:33
 */
public class Solution3 {
    public int findShortestSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        int[] contnums = new int[max - min + 1];
        int degree = 0;
        for (int i : nums) {
            degree = Math.max(degree, ++contnums[i - min]);
        }
        if (degree == 1) return 1;
        int result = nums.length;
        for (int i = 0; i < contnums.length; i++) {
            if (contnums[i] != degree) {
                continue;
            } else {
                int tmp = min + i;
                int start = 0, end = nums.length - 1;
                while (start < end && nums[start] != tmp) {
                    start++;
                }
                while (start < end && nums[end] != tmp) {
                    end--;
                }
                result = Math.min(result, end - start + 1);
            }
        }
        return result;

    }
}
