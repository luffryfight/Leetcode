package cn.kobe;

import java.util.Stack;

/**
 * 作用：
 * 2021/2/7
 */
public class Review {

    //栈
    public int longestValidParentheses2(String s) {
        char[] str = s.toCharArray();//速度快了很多
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);//边界 适应边长
        for (int i = 0; i < s.length(); i++) {
            if (str[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {//没有边界了，以该点为边界
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    //动态规划
    /*
    * dp[i]=dp[i−2]+2
    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
    * */
    public int longestValidParentheses(String s) {
        int len = s.length();
        char[] str = s.toCharArray();

        int[] dp = new int[len];

        int res = 0;
        for (int i = 1; i < len; i++) {
            if (str[i] == ')') {
                if (str[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && str[(i - dp[i - 1] - 1)] == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
