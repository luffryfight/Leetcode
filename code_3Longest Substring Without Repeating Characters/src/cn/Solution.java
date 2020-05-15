package cn;

import javax.sound.midi.Soundbank;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
      /*①可以用暴力解法，两个for
        *②可以从Map储存
        * ③直接用数组保存
        * */
      int res=0;
      int[]str=new int[256];
      for(int left=0,right=0;right<s.length();right++){//left和right之间的距离就是长度
          int temp=s.charAt(right);
            if(str[temp]!=0){//存在重复
                left=Math.max(str[s.charAt(right)],left);//必须比较，不然可能出现“abba"中left变小
            }
            res=Math.max(res,right-left+1);
            str[temp]=right+1;
      }
      return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("abba"));
    }
}
