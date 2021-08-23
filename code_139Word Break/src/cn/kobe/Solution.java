package cn.kobe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*
     * 关系：dp[i]=dp[j] && check(s[j..i−1])
     * */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }


    public static void main(String[] args) {
        /*String str="applepenapple";
        List<String> list=new LinkedList<>();
        list.add("applen");
        list.add("pen");
        System.out.println(Solution.wordBreak(str,list));*/
        System.out.println(10 % 7);
        HashMap<Integer, Integer> m = new HashMap<>();

    }
}
