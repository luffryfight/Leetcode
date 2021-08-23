package cn.kobe;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.*;

public class Solution {
    //同样回溯，可以遍历所有结果
    List<List<Integer>> res = new ArrayList<>();
    //保存结果不重复
    //
    int targets;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        targets = target;
        Arrays.sort(candidates);

        dfs(candidates, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] data, int start, int sum, List<Integer> list) {
        if (sum > targets)
            return;
        if (sum == targets) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < data.length; i++) {
            if (sum + data[i] > targets)//这里就剪枝了
                break;
            list.add(data[i]);
            dfs(data, i, sum + data[i], list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] date = {2, 3, 6, 7};
        Solution so = new Solution();
        System.out.println(so.combinationSum(date, 7));
    }
}
