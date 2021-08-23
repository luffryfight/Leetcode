package cn.kobe;

/**
 * 作用：
 * 2020/10/21
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int i = 0, j = 0;
        char[] str1 = name.toCharArray(), str2 = typed.toCharArray();
        while (i < name.length() || j < typed.length()) {
            char ch1 = str1[i];
            while (i < name.length() && str1[i] == ch1) {
                count1[str1[i] - 'a']++;
                i++;
            }
            char ch2 = str2[j];
            while (j < name.length() && str2[j] == ch2) {
                count2[str2[j] - 'a']++;
                j++;
            }
            if (count1[ch1 - 'a'] > count2[ch2 - 'a'])
                return false;
            //i++;j++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isLongPressedName("leelee", "lllleeeellllee"));
    }
}
