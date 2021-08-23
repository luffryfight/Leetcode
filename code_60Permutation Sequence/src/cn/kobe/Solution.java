package cn.kobe;

import javax.print.DocFlavor;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
    //这个版本不行，n比较大时很容易就超时//需要剪枝
    private int level = 0;
    private String res;
    private boolean flag = false;

    public String getPermutation(int n, int k) {
        Set<Character> b = new LinkedHashSet<>();
        dfs(n, k, new StringBuilder(), b);

        return res;
    }

    private void dfs(int n, int k, StringBuilder str, Set<Character> buckt) {//n是个数
        if (flag) return;
        System.out.println(level);
        if (n == str.length()) {
            level++;
            //---debug
            System.out.println(str + "--" + level);
            if (level == k) {
                res = str.toString();
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            char ch = (char) (i + '0');
            if (buckt.contains(ch)) continue;
            //模板
            str.append(ch);
            buckt.add(ch);

            dfs(n, k, str, buckt);

            str.deleteCharAt(str.length() - 1);
            buckt.remove(ch);
        }
    }
}
