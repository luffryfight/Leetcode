package cn.review;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 强硬做出
 * */
public class Solution2 {
    public static String decodeString(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char last;
        int mult = 1;
        for (int i = 0; i < s.length(); i++) {//遍历
            char temp = s.charAt(i);
            if (temp != ']') {//不是】就入栈
                stack.add(temp);
            } else {
                String pre = new String();
                StringBuilder mul = new StringBuilder();
                while ((last = stack.removeLast()) != '[') {//获取括号里面的
                    pre += last;
                }
                //获取数字
                while (stack.size() != 0 && Character.isDigit(last = stack.removeLast())) {
                    mul.append(last);
                }
                //最后多弹出的压入字母
                if (Character.isAlphabetic(last) || last == '[')
                    stack.add(last);
                //注意倒序
                String str = new String();
                int len = Integer.parseInt(mul.reverse().toString());
                for (int j = 0; j < len; j++) {
                    str += pre;
                }
                for (int i1 = str.length() - 1; i1 >= 0; i1--) {
                    stack.add(str.charAt(i1));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (stack.size() != 0) {
            last = stack.removeLast();
            res.append(last);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";//"3[a]2[bc]""3[a2[c]]"
        System.out.println(Solution3.decodeString(s));
    }
}
