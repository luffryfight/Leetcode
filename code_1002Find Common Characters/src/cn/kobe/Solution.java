package cn.kobe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 作用：
 * 2020/10/14
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        int[] map = new int[26];
        Arrays.fill(map, Integer.MAX_VALUE);
        for (String str : A) {
            int[] count = new int[26];
            char[] s = str.toCharArray();
            for (char ch : s) {
                count[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                map[i] = Math.min(map[i], count[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < map[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        String[] s = {"bella", "label", "roller"};
        System.out.println(so.commonChars(s));
    }

}

class Solution1 {
    public List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}

