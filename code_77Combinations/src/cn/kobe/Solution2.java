package cn.kobe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    //仍然可以剪枝
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, new ArrayList<>(), n, k);
        return res;
    }

    private void dfs(int start, List<Integer> list, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            dfs(i + 1, list, n, k);
            list.remove(list.size() - 1);
        }
    }
}
