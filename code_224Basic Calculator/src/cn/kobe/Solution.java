package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

/**失败版本。。**/
public class Solution {
    Deque<Character> stack=new ArrayDeque<>();
    public int calculate(String s) {
        //转换成数组
        char[] str=s.toCharArray();
        boolean flag=false;
        for(char ch:str){
            if(ch=='+'||ch=='-'){
                flag=true;
            }else if(ch>='0'||ch<'9'||ch=='('){
                if(flag){
                    int sum=(stack.pop()=='+'? stack.pop()-'0'+ch-'0'
                            :stack.pop()-'0'-ch-'0');
                    for(char c:String.valueOf(sum).toCharArray())
                        stack.push(c);
                }
            }else if(ch==')'){
                int sum=0;
                while(!stack.isEmpty()&&stack.peek()!='('){
                    sum=sum*10+stack.pop()-'0';
                }
                stack.pop();//去掉'('
            }
        }
        return 0;
    }
    private void isfind(String s,int index){
        if(index>=s.length())
            return;
        for(int i=index;i<s.length();i++){

        }
    }
}
