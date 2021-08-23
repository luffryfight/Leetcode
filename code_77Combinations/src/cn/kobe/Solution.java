package cn.kobe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //仍然可以剪枝
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, new ArrayList<>(), n, k);
        return res;
    }

    private void dfs(int start, List<Integer> list, int n, int k) {
        if (list.size() == k) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(i + 1, list, n, k);
            list.remove(list.size() - 1);
        }
    }
}
