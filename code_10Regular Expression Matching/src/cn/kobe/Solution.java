package cn.kobe;

public class Solution {
    /*
     * 先写一个递归版本
     * */
    public static boolean isMatch(String s, String p) {
        //递归结束条件
        if (p.length() == 0) return s.length() == 0;
        boolean match;
        if (p.charAt(0) != '.')//处理'.'
            match = s.length() != 0 && s.charAt(0) == p.charAt(0);
        else
            match = s.length() != 0;
        //处理'*'
        if (p.length() >= 2 && p.charAt(1) == '*')//跳过这两个字符或者匹配之后比较下一个
            return isMatch(s, p.substring(2)) || match
                    && isMatch(s.substring(1), p);
        else
            return match && isMatch(s.substring(1), p.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(Solution.isMatch("aaaaaax", ".*"));
    }
}
