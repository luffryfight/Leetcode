package cn.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class Leet438 {
    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        char[] str1 = s.toCharArray();
        char[] str2 = p.toCharArray();
        //
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        //初始化
        int valid = 0;
        for (int i = 0; i < p.length(); i++) {
            tArr[str2[i] - 'a']++;
        }
        int left = 0, right = 0;
        //遍历
        while (right < s.length()) {
            int ch = str1[right] - 'a';
            right++;
            sArr[ch]++;
            while (sArr[ch] > tArr[ch]) {//超出窗口范围
                sArr[str1[left] - 'a']--;
                left++;
            }
            if (right - left == p.length()) {
                list.add(left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s1 = "abab";
        String s2 = "ab";
        System.out.println(Leet438.findAnagrams(s1, s2));
    }
}
