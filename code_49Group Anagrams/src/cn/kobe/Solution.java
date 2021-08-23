package cn.kobe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/4/21 17:11
 */
public class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        //通过一种同一的方式使含有相同字符及个数的字符串能转换成同一  标识
        Map<String, List<String>> map = new HashMap<>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            int[] words = new int[26];
            for (char ch : strs[i].toCharArray()) {//读取出每个字符的个数
                words[ch - 'a']++;
            }
            for (int j = 0; j < 26; j++) {//按从a-z顺序读取出该字符串
                if (words[j] != 0) {
                    sb.append(j + 'a').append(words[j]);
                }
            }
            if (map.containsKey(sb.toString())) {
                List<String> list = map.get(sb.toString());
                list.add(strs[i]);
            } else {//原来没有出现过含这些字母的字符串
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sb.toString(), list);
            }

        }

        for (String str : map.keySet()) {
            res.add(map.get(str));
        }
        return res;
    }
}
