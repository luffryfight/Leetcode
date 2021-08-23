package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用：全排列
 * 2021/1/31
 */
public class Review {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(), 0, 0, n);
        return res;
    }

    public void dfs(StringBuilder sb, int left, int right, int number) {
        if (left == number && right == number) {
            res.add(sb.toString());
            return;
        }
        if (left < number) {
            sb.append('(');
            dfs(sb, left + 1, right, number);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < number && right < left) {
            sb.append(')');
            dfs(sb, left, right + 1, number);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
