package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public static String removeDuplicates(String S) {
        //转换成数组
        char[] str = S.toCharArray();
        //可以不用创建栈，自己实现
        StringBuilder sb = new StringBuilder();

        for (char ch : str) {
            int len = sb.length();
            if (len != 0 && ch == sb.charAt(len - 1))
                sb.deleteCharAt(len - 1);
            else
                sb.append(ch);
        }
        return sb.toString();
    }
    /*
    *
    * Deque<Character> stack=new ArrayDeque<>();
        for (char ch:str) {
            if(!stack.isEmpty()&&stack.peek()==ch)
                stack.pop();
            else
                stack.push(ch);
        }
       * */
}
