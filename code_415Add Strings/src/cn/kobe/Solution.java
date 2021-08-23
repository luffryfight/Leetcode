package cn.kobe;

public class Solution {
    /*之前面试做过这题了，所以难度真的是easy*/
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        //转换为字符串
        char[] str1 = num1.toCharArray();
        char[] str2 = num2.toCharArray();
        int carry = 0;//进位
        while (l1 >= 0 && l2 >= 0) {
            int num = str1[l1] - '0' + str2[l2] - '0' + carry;
            char ch = (char) (num % 10 + '0');
            sb.append(ch);
            carry = num / 10;
            l1--;
            l2--;
        }
        while (l1 >= 0) {
            int num = str1[l1] - '0' + carry;
            char ch = (char) (num % 10 + '0');
            sb.append(ch);
            carry = num / 10;
            l1--;
        }
        while (l2 >= 0) {
            int num = str2[l2] - '0' + carry;
            char ch = (char) (num % 10 + '0');
            sb.append(ch);
            carry = num / 10;
            l2--;
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
