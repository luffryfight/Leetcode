package cn.kobe;

public class Solution {
    //双指针
    public boolean isSubsequence(String s, String t) {
        int l = 0, r = 0;
        while (l < s.length() && r < t.length()) {
            if (s.charAt(l) == t.charAt(r))
                l++;
            //提前结束标志
            if (l == s.length())
                return true;
            r++;
        }
        return l == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        //转换成数组
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int l = 0, r = 0;
        while (l < s.length() && r < t.length()) {
            if (str1[l] == str2[r])
                l++;
            if (l == s.length())
                return true;
            r++;
        }
        return l == s.length();
    }
}
