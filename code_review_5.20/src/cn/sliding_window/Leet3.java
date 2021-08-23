package cn.sliding_window;

import java.sql.SQLOutput;

public class Leet3 {
    public static int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int[] sArr = new int[128];//字典

        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {//滑动窗口
            int index = str[right];
            right++;
            sArr[index]++;
            while (sArr[index] > 1) {//和上一题条件一样
                sArr[str[left]]--;
                left++;
            }
            res = Math.max(right - left, res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Leet3.lengthOfLongestSubstring("abcabcbb"));
    }
}
