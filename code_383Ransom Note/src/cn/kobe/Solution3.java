package cn.kobe;

import java.util.Arrays;

public class Solution3 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        Arrays.sort(r);
        Arrays.sort(m);
        int i = 0, j = 0;
        while(i < r.length && j < m.length){
            if(r[i] > m[j]) j++;
            else if (r[i] < m[j]) return false;
            else { // 一个字母只能用一次，所以当相等时，两个指针都需要移动
                i++;
                j++;
            }
        }
        return i == r.length;
    }

}
