package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    //有点单调栈的意思
    public String removeKdigits(String num, int k) {
        //创建栈
        LinkedList<Character> stack=new LinkedList<>();
        for (char str:num.toCharArray()){
            while(!stack.isEmpty()&&stack.peek()>str&&k>0){
                stack.removeLast();k--;
            }
            stack.addLast(str);
        }//去除剩余
        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }
        StringBuilder sb=new StringBuilder();
        int flag=0;

        for(char ch:stack){
            if (ch=='0'&&flag==0) continue;
            sb.append(ch);flag=1;
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.removeKdigits("10200",1));
    }
}
