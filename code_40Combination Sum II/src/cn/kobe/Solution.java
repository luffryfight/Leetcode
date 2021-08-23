package cn.kobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    //同样回溯，可以遍历所有结果
    List<List<Integer>> res = new ArrayList<>();
    //保存结果不重复
    //
    int targets;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        targets = target;
        Arrays.sort(candidates);
        //HashSet s=new HashSet<Integer>() ;
        dfs(candidates, 0, 0, new ArrayList<>(), new HashSet<Integer>());
        return res;
    }

    private void dfs(int[] data, int start, int sum, List<Integer> list, HashSet<Integer> s) {
        if (sum > targets)
            return;
        if (sum == targets) {
            if (!res.contains(list))
                res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < data.length; i++) {
            if (sum + data[i] > targets)//这里就剪枝了
                break;
            if (i > start && data[i] == data[i - 1])//小剪枝
                continue;
            list.add(data[i]);
            dfs(data, i + 1, sum + data[i], list, s);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] date = {10, 1, 2, 7, 6, 1, 5};
        Solution so = new Solution();
        System.out.println(so.combinationSum2(date, 8));
    }
}
