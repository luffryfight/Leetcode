package cn.kobe;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        getParents("", n, n);
        return res;
    }

    private void getParents(String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left > 0)
            getParents(str + '(', left - 1, right);
        if (right > 0)
            getParents(str + ')', left, right - 1);
    }
}
