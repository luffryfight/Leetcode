package cn.kobe;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 100000;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int scores = nums[l] + nums[r] + nums[i];
                if (scores == target)
                    return scores;
                else if (scores < target) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
                //取最接近的
                int a = Math.abs(target - res);
                int b = Math.abs(target - scores);
                if (b < a)
                    res = scores;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(nums, 1));
    }
}
