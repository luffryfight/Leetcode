package cn.kobe;

import java.util.LinkedHashSet;
import java.util.Set;

public class Solution2 {
    //这个版本不行，n比较大时很容易就超时//需要剪枝
    private int k;
    private int n;
    private int[] factorical = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};
    private boolean[] used;

    public String getPermutation(int n, int k) {
        this.k = k;
        this.n = n;
        used = new boolean[n];
        calculateFactorial(n);

        StringBuilder sb = new StringBuilder();
        dfs(n - 1, sb);

        return sb.toString();
    }

    private void dfs(int index, StringBuilder str) {//index是个数
        if (index == n) {
            return;
        }

        int count = factorical[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            if (k > count) {
                k -= count;
                continue;
            }
            str.append(i);
            used[i] = true;
            dfs(index + 1, str);

            //后面没必要剪枝，因为前面有一个continue 跳过了很多
            return;
        }
    }

    private void calculateFactorial(int n) {
        factorical = new int[n + 1];
        factorical[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorical[i] = factorical[i - 1] * i;
        }
    }
}
