package cn.kobe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * to do :通过质数来同一
 * 用单独一个质数来对应一个字母
 * 超过百分百了
 *
 * @author 86137
 * @date 2021/4/21 17:18
 */
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        for (String str : strs) {
            Long key = getBit(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                ret.add(list);
                map.put(key, list);
            }
        }
        return ret;
    }

    private long[] prime = new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    private Long getBit(String str) {
        long res = 1;
        for (int i = 0; i < str.length(); i++) {
            res *= prime[str.charAt(i) - 'a'];
        }
        return res;
    }
}
