package cn.kobe;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String smallestSubsequence(String text) {
        if (text.length() <= 1)
            return text;
        //转成字符串
        char[] str = text.toCharArray();
        //保存个数
        int[] count = new int[256];
        for (char ch : str) {
            count[ch]++;
        }
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        char temp;
        for (char ch : str) {
            //需要一个数组判读是否字符是否存在栈中
            //有内置函数
            count[ch]--;
            if (stack.contains(ch)) continue;

            while (!stack.isEmpty() && ch < stack.peekLast() && count[stack.peek()] > 0) {
                int num = count[stack.peek()];
                stack.pop();
            }
            stack.addLast(ch);
        }
        //弹出结果
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pollLast());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.smallestSubsequence("ecbacba"));
    }
}
