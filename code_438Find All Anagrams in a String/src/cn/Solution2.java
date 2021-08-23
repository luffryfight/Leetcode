package cn;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length())
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] sArr = new int[26];//保存s的值
        int[] pArr = new int[26];//保存p的值
        //前p.length()先初始化
        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }

        int pl = p.length();
        while (pl < s.length()) {
            if (isSame(sArr, pArr)) {
                list.add(pl - p.length());
            }
            sArr[s.charAt(pl) - 'a']++;
            sArr[s.charAt(pl - p.length()) - 'a']--;//窗口之外的--
            pl++;
        }
        if (isSame(sArr, pArr)) {//因为循环结束后还要一组没有比较
            list.add(pl - p.length());
        }
        return list;
    }

    public boolean isSame(int[] a1, int[] a2) {
        for (int i = 0; i < a2.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
}
