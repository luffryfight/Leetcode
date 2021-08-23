package cn.test;

import java.util.Arrays;

/**
 * 作用：
 * 2021/1/26
 */
public class Review {
    //简单方式：也就是模拟题目
    public String convert1(String s, int numRows) {
        String[] str = new String[numRows];//可以换成集合 List<StringBuilder>
        Arrays.fill(str, "");
        int n = 0, flag = 1;
        for (char ch : s.toCharArray()) {
            int index = n % numRows;
            if (numRows - 1 == n) {
                flag = -1;
            } else if (n == 0) {
                flag = 1;
            }
            n += flag;
            String temp = new String(str[index] + ch);
            StringBuilder now = new StringBuilder(str[index]);
            now.append(ch);
            str[index] = now.toString();
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(str[i]);
        }
        return res.toString();
    }

    //数学规律：第一行：2n-2
    //对于其他行：两个公差为 2 * (numRows − 1) 的两个等差数列交替排列，首项分别是 i 和 2*numRows-i-2
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len == 1 || numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int start = i, dis = 2 * (numRows - 1);//首相和公差
                while (start < len) {
                    sb.append(str[start]);
                    start += dis;
                }
            } else {
                int start = i, startInd = 2 * numRows - i - 2;//两个首项
                int dis = 2 * (numRows - 1);//公差
                while (start < len || startInd < len) {
                    if (start < len) {
                        sb.append(str[start]);
                        start += dis;
                    }
                    if (startInd < len) {
                        sb.append(str[startInd]);
                        startInd += dis;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Review review = new Review();
        System.out.println(review.convert("PAYPALISHIRING", 3));
        System.out.println("PAHNAPLSIIGYIR".equals(review.convert("PAYPALISHIRING", 3)));
        //PAHNALIGYIRPSI
    }
}
