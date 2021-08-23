package cn.koobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    //保存结果不重复
    int targets;

    public List<List<Integer>> combinationSum3(int k, int n) {
        targets = n;
        dfs(1, 0, new ArrayList<>(), k);
        return res;
    }

    private void dfs(int start, int sum, List<Integer> list, int k) {

        if (sum >= targets || list.size() == k) {//这两种情况都停止深入
            if (list.size() == k && sum == targets)
                res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs(i + 1, sum + i, list, k);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] date = {10, 1, 2, 7, 6, 1, 5};
        Solution so = new Solution();
        System.out.println(so.combinationSum3(3, 7));
    }
}
