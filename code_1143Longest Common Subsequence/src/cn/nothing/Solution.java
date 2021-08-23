package cn.nothing;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = 0, len2 = 0;
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();

        //int[] s1=new int[26];
        int[] s2 = new int[26];

        int count = 0;
        /*for (int i = 0; i < str1.length; i++) {
            s1[str1[i]-'a']++;
        }*/
        for (int i = 0; i < str2.length; i++) {
            s2[str2[i] - 'a']++;
        }

        for (int i = 0; i < str1.length; i++) {
            int index = str1[i] - 'a';
            if (s2[index] != 0) {
                s2[index]--;
                count++;
            }
        }
        return count;
    }
}
