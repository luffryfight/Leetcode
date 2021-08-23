package cn.happy;

public class Solution {
    public void reverseString(char[] s) {
        if (s.length <= 1) return;
        int len = s.length;
        char temp = 0;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }
}
