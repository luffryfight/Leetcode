package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int minAddToMakeValid(String S) {
        int res=0;
        //转换成数组
        char[] arr=S.toCharArray();
        Deque<Character> stack=new ArrayDeque<>();
        for (char ch:arr) {
            if(stack.isEmpty())
                stack.push(ch);
            else {
                int dis=ch-stack.peek();
                if(dis==1)
                    stack.pop();
                else
                    stack.push(ch);
            }
        }
        return stack.size();
    }
}
