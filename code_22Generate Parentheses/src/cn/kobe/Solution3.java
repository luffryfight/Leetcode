package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用： 用标准回溯格式写
 * 2020/10/14
 */
public class Solution3 {
    List<String> res = new ArrayList<>();
    int target = 0;

    public List<String> generateParenthesis(int n) {
        if (n < 1)
            return null;
        target = n;
        dfs(0, 0, new StringBuilder());
        return res;
    }

    public void dfs(int left, int right, StringBuilder str) {
        if (left == target && right == target) {
            res.add(str.toString());
        }
        if (left > target || right > target || right > left) return;
        //回溯
        str.append('(');
        dfs(left + 1, right, str);
        str.deleteCharAt(str.length() - 1);
        //右边
        str.append(')');
        dfs(left, right + 1, str);
        str.deleteCharAt(str.length() - 1);
    }
}
