package cn.kobe;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 作用：很直观的思路，用最多的和小的依次匹配
 * 2020/11/30
 */
public class Solution {
    public String reorganizeString(String S) {
        int[] arr=new int[26];
        char[] str=S.toCharArray();
        for (int i = 0; i < str.length; i++) {
            arr[str[i]-'a']++;
            if (arr[str[i]-'a']>(str.length+1)/2)//这里就判断到底能不能重构了
                return "";
        }
        PriorityQueue<Character> priority=new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return arr[o2-'a']-arr[o1-'a'];
            }
        });
        for (char i = 'a'; i <= 'z'; i++) {
            if (arr[i-'a']!=0){
                priority.offer(i);
            }
        }
        StringBuilder sb=new StringBuilder();
        while (priority.size()>1){//至少有两个
            char ch1=priority.poll(),ch2=priority.poll();
            sb.append(ch1);sb.append(ch2);
            arr[ch1-'a']--;arr[ch2-'a']--;
            if ((arr[ch1-'a'])>0)
                priority.offer(ch1);
            if ((arr[ch2-'a'])>0)
                priority.offer(ch2);
        }
        if (priority.size()>0){//可能还有多余的一个
            sb.append(priority.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str="vvvlo";
        Solution solution=new Solution();
        System.out.println(solution.reorganizeString(str));
    }
}
