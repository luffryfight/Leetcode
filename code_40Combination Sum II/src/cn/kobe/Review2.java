package cn.kobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * to do : 复习回溯，注意剪枝
 * 能少调用一次递归，效率会+很多
 *
 * @author 86137
 * @date 2021/2/21 15:19
 */
class Review2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, 0, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] nums, int index, int target, int sum, List<Integer> list) {
        /*
            if(sum==target){
            if(!res.contains(list))
                res.add(new ArrayList<>(list));
            return;
            }
        */

        for (int i = index; i < nums.length; i++) {
            if (nums[i] + sum > target) return;//剪枝1  这里
            if (i > index && nums[i] == nums[i - 1]) continue;//剪枝2
            if ((sum + nums[i]) == target) {//这里保存结果比继续再调用一次好
                ArrayList l = new ArrayList(list);
                l.add(nums[i]);
                res.add(l);
                break;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, target, sum + nums[i], list);
            list.remove(list.size() - 1);
        }
    }
}
