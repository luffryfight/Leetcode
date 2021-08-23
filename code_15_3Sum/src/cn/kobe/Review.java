package cn.kobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作用：
 * 2021/1/30
 */

class Review {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 1) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            if (nums[i] > 0) break;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int num = nums[left] + nums[right];
                if (num + nums[i] == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                } else if (nums[i] + num < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
