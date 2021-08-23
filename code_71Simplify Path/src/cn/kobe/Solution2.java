package cn.kobe;

import javax.jws.soap.SOAPBinding;
import java.util.Stack;

/*
 * 优化代码，虽然效率没有优化
 * */
public class Solution2 {
    public static String simplifyPath(String path) {
        String[] str = path.split("/");

        Stack<String> stack = new Stack();
        for (int i = 1; i < str.length; i++) {//注意要从1开始
            if (str[i].equals("..")) {//返回上一级
                if (!stack.isEmpty())//且不为空
                    stack.pop();//删除最后一个
                else continue;
            } else if (!str[i].equals(".") && !str[i].equals("")) {
                stack.add('/' + str[i]);
            }
        }
        StringBuffer res = new StringBuffer();//比sbuilder快一点
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            res.append(stack.get(i));
        }
        return size == 0 ? "/" : res.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution2.simplifyPath("/a//b////c/d//././/.."));
    }
}
