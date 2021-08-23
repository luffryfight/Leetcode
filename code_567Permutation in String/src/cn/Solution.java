package cn;

import java.util.HashMap;

public class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        //转换为字符串，增加读取效率
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        //初始化字符串
        for (int i = 0; i < str1.length; i++) {
            s1Arr[str1[i] - 'a']++;
        }
        //定义指针
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char ch = str2[right];
            right++;
            if (s1.indexOf(ch) != -1) {//存在
                s2Arr[ch - 'a']++;
                valid++;
            }
            while (right - left >= str1.length) {
                if (valid == str1.length && isCan(s1Arr, s2Arr)) {
                    return true;
                }
                char temp = str2[left];
                left++;
                if (s2Arr[temp - 'a'] != 0) {
                    s2Arr[temp - 'a']--;
                    valid--;
                }

            }
        }
        return false;
    }

    public static boolean isCan(int[] s1, int s2[]) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aac";

        String s2 = "eiadbboaaoo";
        System.out.println(Solution.checkInclusion(s1, s2));
    }
}
