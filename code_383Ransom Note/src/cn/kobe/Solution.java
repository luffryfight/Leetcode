package cn.kobe;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length(), len2 = magazine.length();
        if (len1 < len2) return false;

        //创建对应数组
        char[] str1 = ransomNote.toCharArray();
        char[] str2 = magazine.toCharArray();
        //定义两个指针
        int l = 0, r = 0;
        int valid = 0;
        while (r < len2) {
            char ch = str2[r];
        }
        return false;
    }
}
