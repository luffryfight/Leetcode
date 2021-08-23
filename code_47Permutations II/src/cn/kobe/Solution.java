package cn.kobe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    //虽然通过了，但是很慢。
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<Integer> buckt = new HashSet<>();
        dfs(nums, new ArrayList<>(), buckt, nums.length);

        return res;
    }

    public void dfs(int[] nums, List<Integer> list, Set<Integer> buckt, int n) {
        if (list.size() == n) {
            if (!res.contains(list))
                res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (buckt.contains(i)) continue;

            list.add(nums[i]);
            buckt.add(i);
            //回溯
            dfs(nums, list, buckt, n);

            list.remove(list.size() - 1);
            buckt.remove(i);
        }
    }
}
