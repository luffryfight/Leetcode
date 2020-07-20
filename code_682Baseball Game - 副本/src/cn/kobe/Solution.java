package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack=new ArrayDeque<>();
        //思路简单。。。
        for(String str:ops){
            if("C".equals(str)){
                stack.pop();
            }else if("D".equals(str)){
                stack.push(stack.peek()*2);
            }else if("+".equals(str)){
                int prenum=stack.pop();
                int pprenum=stack.pop();
                stack.push(pprenum);
                stack.push(prenum);
                stack.push(prenum+pprenum);
            }else{
                int num=Integer.parseInt(str);
                stack.push(num);
            }
        }
        int res=0;
        int size=stack.size();
        for (int i = 0; i < size; i++) {
            res+=stack.pop();
        }
        return res;
    }
}
