package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用：回溯，全排列算法
 * 2021/1/31
 */
public class Review {
    //回溯，全排列算法
    List<String> res = new ArrayList<>();
    String[] gets = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len < 1) {
            return res;
        }
        dfs(new StringBuilder(), 0, len, digits.toCharArray());
        return res;
    }

    public void dfs(StringBuilder sb, int index, int len, char[] str) {
        if (len == index) {
            res.add(sb.toString());
            return;
        }
        String s = gets[str[index] - '0'];
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            dfs(sb, index + 1, len, str);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
