package cn.kobe;

public class Solution {
    //写出来居然超时
    public String shortestPalindrome(String s) {
        if (s.length() < 1)
            return "";
        int ptr = s.length();//substr是【)
        StringBuilder str = new StringBuilder(s);
        StringBuilder sb = new StringBuilder();
        for (int i = ptr; i >= 0; i--) {
            if (isPalindrome(str.toString())) {//加上当前字符是回文了就返回结果
                return sb.toString() + s;//最差会在最后一个时执行
            } else {
                sb.append(s.charAt(i - 1));
            }
            str.deleteCharAt(str.length() - 1);
        }
        return "";
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
