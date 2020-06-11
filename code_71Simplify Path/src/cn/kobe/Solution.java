package cn.kobe;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import sun.security.x509.IPAddressName;

import javax.swing.*;
import java.util.Stack;
/*
* 略显复制，但好歹对了，但其实又是队列的思想。
* */
public class Solution {
    public static String simplifyPath(String path) {
        StringBuilder sb1=new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char temp= path.charAt(i);
            if(i!=0&&temp=='/'&& path.charAt(i-1)=='/')
                continue;;
            sb1.append(temp);
        }
        String[] str=sb1.toString().split("/");

        Stack<String> stack=new Stack();
        for (int i = 1; i < str.length; i++) {//注意要从1开始
            if(str[i].equals("..")){//返回上一级
                if(!stack.isEmpty())//且不为空
                     stack.pop();//删除最后一个
                else continue;
            }else if(!str[i].equals(".")){
                stack.add('/'+str[i]);
            }
        }
        StringBuilder res=new StringBuilder();
        int size=stack.size();
        for (int i = 0; i < size; i++) {
            res.append(stack.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution.simplifyPath("/home/../"));
    }
}
