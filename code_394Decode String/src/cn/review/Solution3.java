package cn.review;

import java.util.Stack;

/*
 * 标准方法：
 * 如果是'['就放入对应栈
 * */
public class Solution3 {
    public static String decodeString(String s) {
        Stack<Integer> m = new Stack();
        Stack<String> r = new Stack();

        int multi = 0;
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                m.push(multi);
                r.push(res.toString());
                multi = 0;//重新赋值，因为每串字母前都有数字所以multi=0也无所谓
                res = new StringBuilder();
            } else if (c == ']') {//向后遍历
                Integer i = m.pop();
                String before = r.pop();
                StringBuilder temp = new StringBuilder();
                while (i != 0) {//✖倍数
                    temp.append(res);
                    i--;
                }//注意before在前面
                res = new StringBuilder(before + temp.toString());
                multi = 0;
            } else if (c >= '0' && c <= '9') {//是数字
                multi = multi * 10 + c - '0';
            } else {//是字母
                res.append(c);
            }
            //bug:"3[a2[c]]"
            System.out.println(res);
        }
        return res.toString();
    }

}
