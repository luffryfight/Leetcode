package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;
/*
* free bug
* 但是还有优化，这都能优化。。
* */
public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")){
                stack.add(stack.pollLast()+stack.pollLast());
            }else if(tokens[i].equals("-")){
                int pre=stack.pollLast();
                stack.add(stack.pollLast()-pre);
            }else if(tokens[i].equals("*")){
                stack.add(stack.pollLast()*stack.pollLast());
            }else if(tokens[i].equals("/")){
                int pre=stack.pollLast();//不存在为0的情况
                stack.add(stack.pollLast()/pre);
            }else{
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peekLast();
    }
}
