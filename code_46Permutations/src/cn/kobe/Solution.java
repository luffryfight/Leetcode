package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/4/19 15:22
 */
class Solution {
    // 减少回溯函数传参
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int nums[], int k) {
        if (k == nums.length - 1) {
            List<Integer> path = new ArrayList<>();
            for (int num : nums) {
                path.add(num);
            }
            res.add(path);
            return;
        }

        for (int i = k; i < nums.length; i++) {
            swap(nums, i, k);
            backtrack(nums, k + 1);
            swap(nums, i, k);
        }
    }

    private void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
