package cn.kobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/4/21 17:22
 */
public class Solution3 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] ch = s.toCharArray();//这一步很妙了，自己想的就是直接排序String 类型。
                Arrays.sort(ch);
                String key = String.valueOf(ch);
                if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(s);
            }
            return new ArrayList(map.values());
        }
    }
}
