package cn.kobe;

import java.util.HashMap;
import java.util.Map;

/**
 * to do :参考官方题解，题解是直接保存每个元素的起始和结束位置，
 * 然后找到出现次数最多的元素（可能有多个）取最小值
 * 我做的是找到含max次数的元素的区间，然后缩小区间！
 *
 * @author 86137
 * @date 2021/2/20 15:28
 */
class Solution2 {
    //比我的题解稍微快一点
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }
}

