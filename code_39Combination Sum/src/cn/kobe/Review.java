package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/2/20 16:18
 */
public class Review {
    //要是单个元素只能计算一次，感觉可以用滑动窗口做
    //计算组合还是考虑 回溯算法
    //慢慢来考虑优化，剪枝
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, candidates, 0, target, new ArrayList<>());
        return res;
    }

    public void dfs(int index, int[] nums, int sum, int target, List<Integer> list) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(i, nums, sum + nums[i], target, list);
            list.remove(list.size() - 1);
        }
    }
}
