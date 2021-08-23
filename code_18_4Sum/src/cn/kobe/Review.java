package cn.kobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作用：复习
 * 2021/1/30
 */
class Review {
    //注意带双斜杠的地方
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;//
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) continue;//
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;//
                if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) continue;//
                int left = j + 1, right = len - 1;
                while (left < right) {
                    int num = nums[i] + nums[j] + nums[left] + nums[right];

                    if (num == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        while (left < right && nums[left] == nums[left + 1]) left++;//
                        while (left < right && nums[right - 1] == nums[right]) right--;//
                        left++;
                        right--;
                    } else if (num < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
