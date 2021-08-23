package cn.kobe;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //和回溯的思路其实也差不多
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dif(n, n, "");
        return res;
    }

    public void dif(int left, int right, String str) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        //加左括号
        if (left > 0)
            dif(left - 1, right, str + "(");
        //
        if (right > left)
            dif(left, right - 1, str + ")");
    }
}
