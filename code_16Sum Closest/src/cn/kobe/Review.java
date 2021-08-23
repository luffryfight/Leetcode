package cn.kobe;

import java.util.Arrays;

/**
 * 作用：复习
 * 2021/1/30
 */
class Review {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, flag = -1;//falg 用来标记第一次赋值
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int num = nums[i] + nums[left] + nums[right];
                if (flag == -1 || Math.abs((target - num)) < Math.abs((target - res))) {
                    res = num;
                    flag = 1;
                }
                if (num == target) {
                    return target;
                } else if (num < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        return res;
    }
}
