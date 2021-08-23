package cn.kobe;

/**
 * 作用：进阶 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * 双指针   100% 100%
 * 2020/10/21
 */
public class Solution2 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipi = 0, skipj = 0;
        char[] str1 = S.toCharArray(), str2 = T.toCharArray();
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (str1[i] == '#') {
                    skipi++;
                    i--;
                } else if (skipi > 0) {
                    i--;
                    skipi--;
                } else break;
            }
            while (j >= 0) {
                if (str2[j] == '#') {
                    skipj++;
                    j--;
                } else if (skipj > 0) {
                    j--;
                    skipj--;
                } else break;
            }
            if (i >= 0 && j >= 0) {
                if (str1[i] != str2[j])
                    return false;
            } else if (i >= 0 || j >= 0) {//一个小于0一个大于0
                return false;
            }
            j--;
            i--;
        }
        return true;
    }
}
