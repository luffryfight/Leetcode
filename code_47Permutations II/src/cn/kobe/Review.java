package cn.kobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/4/19 15:52
 */
public class Review {
    List<List<Integer>> res = new ArrayList<>();
    HashSet<Integer> buckets = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(0, nums, new ArrayList<Integer>(), new HashSet<Integer>());
        return res;
    }

    public void dfs(int index, int[] nums, List<Integer> list, HashSet<Integer> set) {
        if (index == nums.length) {
            if (!res.contains(list))
                res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && buckets.contains(nums[i])) continue;
            if (!set.contains(i)) {
                list.add(nums[i]);
                set.add(i);
                dfs(index + 1, nums, list, set);
                list.remove(list.size() - 1);
                set.remove(i);
            }

        }
    }

    public static void main(String[] args) {
        Review review = new Review();
        int[] nums = {1, 1, 2};
        review.permuteUnique(nums);
    }
}
