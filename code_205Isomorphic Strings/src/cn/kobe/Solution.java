package cn.kobe;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        //转换为字符数组
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] arr = new int[128];//判断两个字符是否重复指向同一个字符
        for (int i = 0; i < sArr.length; i++) {
            if (!map.containsKey(sArr[i])) {
                if (arr[tArr[i]] != 0)
                    return false;
                map.put(sArr[i], tArr[i]);
                arr[tArr[i]]++;
            } else {
                if (tArr[i] != map.get(sArr[i])) return false;
            }
        }
        return true;
    }
}
