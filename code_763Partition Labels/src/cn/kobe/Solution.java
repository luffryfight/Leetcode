package cn.kobe;

import sun.management.snmp.util.JvmContextFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用：100% 牛逼啊我
 * 做完题目才发现是贪心的思想
 * 2020/10/23
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] finals = new int[26];//最后出现的位置
        boolean[] visit = new boolean[26];//跳过重复出现的
        char[] str = S.toCharArray();
        for (int i = 0; i < str.length; i++) {
            finals[str[i] - 'a'] = i;
        }
        int i = 0;
        while (i < str.length) {
            if (visit[str[i] - 'a']) continue;
            int index = finals[str[i] - 'a'];//获取最后出现的索引
            visit[str[i] - 'a'] = true;
            for (int j = i; j < index; j++) {
                if (visit[str[j] - 'a']) continue;
                if (finals[str[j] - 'a'] > index) {
                    index = finals[str[j] - 'a'];//如果当前字母索引超过，则扩大范围
                }
                visit[str[j] - 'a'] = true;
            }
            int nums = index + 1 - i;
            res.add(nums);//个数
            i += nums;
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels(S));
    }
}
