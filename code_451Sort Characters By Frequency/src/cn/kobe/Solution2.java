package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86137
 * @date 2021/7/3 23:42
 * TODO:看到的一个简单且效率不错的方法。 84%
 */
public class Solution2 {
    public String frequencySort(String s) {
        //统计个数
        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int min=Integer.MAX_VALUE;
        //拿到每个字符（只要一个）
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                list.add((char) i);
            }
        }
        //排序出现的字符  最重要的一步
        list.sort(((o1, o2) -> count[o2] - count[o1]));
        //添加结果
        StringBuilder sb=new StringBuilder();
        for (Character ch : list) {
            for (int i = 0; i < count[ch]; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
