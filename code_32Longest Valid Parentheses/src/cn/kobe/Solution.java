package cn.kobe;

import java.util.Stack;

public class Solution {
    //比较暴力的做法，果然超出 时间了
    public int longestValidParentheses(String s) {
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        //遍历每一次
        int max=0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if(isValid(s.substring(i,j+1))){
                    max=Math.max(max,j-i+1);
                    dp[i][j]=true;
                }

            }
        }
        return max;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s="((()))()((";
        System.out.println(s.substring(0,5));
    }
}
