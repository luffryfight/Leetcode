package cn;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 作用：复习
 * 2021/1/24
 */
public class Review {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0, right = 0;
        int[] str = new int[256];
        char[] chars = s.toCharArray();
        while (right < s.length()) {//abba
            char ch = chars[right];
            if (str[ch] != 0) {
                left = Math.max(str[ch], left);
            }
            res = Math.max(res, right - left + 1);
            str[ch] = right + 1;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        Review review = new Review();
        System.out.println(review.lengthOfLongestSubstring("dvdf"));
    }
}
