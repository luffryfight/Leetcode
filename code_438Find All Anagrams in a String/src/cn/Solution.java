package cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    /*
    * 内层while是关键,s和p转化成char[]读取效率比charAt高
    * */
    public List<Integer> findAnagrams(String s, String p) {
        if(s==null||p==null||s.length()<p.length())
            return new ArrayList<>();
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        // 接收最后返回的结果
        List<Integer> ans = new ArrayList<>();

        // 定义一个 needs 数组来看 arrP 中包含元素的个数
        int[] needs = new int[26];
        // 定义一个 window 数组来看滑动窗口中是否有 arrP 中的元素，并记录出现的个数
        int[] window = new int[26];

        // 先将 arrP 中的元素保存到 needs 数组中
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        }

        // 定义滑动窗口的两端
        int left = 0;
        int right = 0;

        // 右窗口开始不断向右移动
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            // 将右窗口当前访问到的元素 curR 个数加 1
            window[curR]++;
            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (window[curR] > needs[curR]) {//说明窗口内的字符串和目标串不同了
                //最重要的这个循环，提高了速度
                // 将左窗口当前访问到的元素 curL 个数减 1//比如abc时出现e，就必须left右移到e的值--
                window[arrS[left] - 'a']--;
                left++;
            }
            //窗口大小符合要求就添加索引
            if (right - left +1== arrP.length) {//因为right先++了，所以窗口大小判断是对的
                ans.add(left);
            }
            right++;
        }
        return ans;
    }
}
