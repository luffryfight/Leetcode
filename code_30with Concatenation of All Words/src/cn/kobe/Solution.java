package cn.kobe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作用：m*n
 * 2021/2/11
 */
public class Solution {
    //参考题解windliang
    List<Integer> res = new ArrayList();
    int len = 0;

    public List<Integer> findSubstring(String s, String[] words) {
        int wordNums = words.length;
        if (wordNums == 0) {
            return res;
        }
        int wordLen = words[0].length();

        Map<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);//因为words中可能会有多个相同的
        }

        for (int i = 0; i < s.length() - wordLen * wordNums + 1; i++) {//i<13 =18-6=12 +1
            int num = 0;
            Map<String, Integer> hasWords = new HashMap<>();
            while (num < wordNums) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);//加+1
                    //个数超过
                    if (value + 1 > allWords.get(word)) break;
                } else break;//步含有
                num++;
            }
            if (num == wordNums) {
                res.add(i);
            }
        }
        return res;
    }
}
