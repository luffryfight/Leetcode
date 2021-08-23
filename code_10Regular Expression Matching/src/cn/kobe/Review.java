package cn.kobe;

import java.io.Reader;

/**
 * 作用：
 * 2021/1/27
 */
public class Review {
    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    public boolean dfs(char[] s, char[] p, int one, int two) {

        for (int i = one, j = two; i < s.length && j < p.length; i++, j++) {
            if (s[i] == p[j] || p[j] == '.') {
                if (dfs(s, p, i + 1, j + 1)) {
                    return true;
                }
                return false;
            } else if (p[j] == '#' && p[j - 1] == s[i]) {
                if (dfs(s, p, i + 1, j)) {
                    return true;
                }
            } else
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Review review = new Review();
        System.out.println(review.isMatch("aa", "a"));
    }
}
