package cn.kobe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/4/19 15:19
 */
public class Review {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(0, nums, new ArrayList<Integer>());
        return res;
    }

    static HashSet<Double> set = new HashSet<>();

    public void dfs(int index, int[] nums, List<Integer> list) {

        if (index == nums.length) {
            res.add(new ArrayList(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(index + 1, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
