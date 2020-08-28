package cn.kobe;

import java.util.Arrays;

public class Solution2 {
    //复习kmp算法
    //优化因此，我们在预处理出 fail\textit{fail}fail 数组后，只需要判断 nnn 是否为 n−fail[n−1]−1n - \textit{fail}[n-1] - 1n−fail[n−1]−1 的倍数即可。
    public boolean repeatedSubstringPattern(String s) {
        return kmp(s);
    }

    public boolean kmp(String pattern) {
        int n = pattern.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        return fail[n - 1] != -1 && n % (n - fail[n - 1] - 1) == 0;
    }

}
