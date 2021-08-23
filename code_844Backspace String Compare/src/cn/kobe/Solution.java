package cn.kobe;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 作用：补上前两天的作业。。。。顺便复习一下java中使用栈的注意事项
 * 2020/10/21
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] str1 = S.toCharArray();
        char[] str2 = T.toCharArray();
        Deque<Character> s1 = new ArrayDeque<>();
        Deque<Character> s2 = new ArrayDeque<>();
        for (char ch : str1) {
            if ('#' == ch) {
                if (!s1.isEmpty())
                    s1.removeLast();
                continue;
            }
            s1.addLast(ch);
        }
        for (char ch : str2) {
            if ('#' == ch) {
                if (!s2.isEmpty())
                    s2.removeLast();
                continue;
            }
            s2.addLast(ch);
        }
        if (s1.size() != s2.size())
            return false;
        while (!s1.isEmpty()) {
            if (s1.pop() != s2.pop())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "bxj##tw";
        String s2 = "bxj###tw";
        Solution2 solution = new Solution2();
        System.out.println(solution.backspaceCompare(s1, s2));
    }

}
