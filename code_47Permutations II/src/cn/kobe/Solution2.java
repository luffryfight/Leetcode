package cn.kobe;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.lang.reflect.Array;
import java.util.*;

public class Solution2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), used, nums.length);

        return res;
    }

    public void dfs(int[] nums, List<Integer> list, boolean[] used, int n) {
        if (list.size() == n) {
            //if(!res.contains(list))  //这个判断多余，并且很占时间
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            //剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {//比used[i - 1] 的剪枝效果好，是正着剪枝，反之的话剪枝就是很乱
                //https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            //回溯
            dfs(nums, list, used, n);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
