package cn.kobe;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public String multiply(String num1, String num2) {


        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int l1 = num1.length(), l2 = num2.length();
        //转换为数组
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        int[] str = new int[l1 + l2];

        int carry = 0;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                int num = (s1[l1 - i - 1] - '0') * (s2[l2 - j - 1] - '0');
                int add = num + (str[i + j]);//要加的数
                carry = add / 10;
                str[i + j + 1] += carry;
                str[i + j] = add % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = l1 + l2 - 1;
        for (; index >= 0 && str[index] == 0; index--) ;
        for (int i = 0; i < str.length && i <= index; i++) {
            sb.append(str[i]);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[2] = 12313;
        final String s1 = String.valueOf(arr);
        StringBuilder stringBuilder = new StringBuilder();
        String s = new String(arr, 0, arr.length);
        System.out.println(s);
    }
}
