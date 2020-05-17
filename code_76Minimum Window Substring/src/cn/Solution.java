package cn;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;

public class Solution {
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> window=new HashMap<>();
        HashMap<Character,Integer> needs=new HashMap<>();
        //转化为数组
        char []s1=s.toCharArray();
        char []s2=t.toCharArray();

        //定义指针
        int left=0,right=0;

        //为了满足题目要求
        int valid=0;
        int f_index=0;
        int len=Integer.MAX_VALUE;

        //初始化needs
        for (int i = 0; i < t.length(); i++) {
            needs.put(s2[i],needs.getOrDefault(s2[i],0)+1);
        }

        //滑动窗口
        while(right<s.length()){
            char ch=s1[right];

            //符合要求
            if(needs.containsKey(ch)){
                window.put(ch,window.getOrDefault(ch,0)+1);
                if(window.get(ch).compareTo(needs.get(ch))==0)
                    valid++;
            }
            //缩小窗口
             while(valid==s2.length){
                //保存窗口索引
                if(right-left<len){
                    len=right-left+1;
                    f_index=left;
                }
                char temp=s1[left];
                if(needs.containsKey(temp)) {
                    if(window.get(temp).compareTo(needs.get(temp))==0)
                        valid--;
                    window.put(temp,window.getOrDefault(temp,1)-1);
                }
                left++;
            }

            right++;
        }
        if(len==Integer.MAX_VALUE){
            return new String("");
        }
        return s.substring(f_index,len+f_index);
    }


}
