package cn.kobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/2/21 15:12
 */
class Review {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, 0, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] nums, int index, int target, int sum, List<Integer> list) {
        if (sum == target) {
            if (!res.contains(list))
                res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] + sum > target) return;//剪枝1  这里剪枝直接就不通过
            if (i > index && nums[i] == nums[i - 1]) continue;//剪枝2

            list.add(nums[i]);
            dfs(nums, i + 1, target, sum + nums[i], list);
            list.remove(list.size() - 1);
        }
    }
}
