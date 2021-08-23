package cn.kobe;

public class Solution2 {
    /*
     * 因为字符串长度问题，转换成整数肯定没戏；
     * 类似于大数相加的做法了
     * */
    public static String addBinary(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        StringBuilder res = new StringBuilder();
        //转换成字符串
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int carry = 0;//处理进位的问题
        for (; len1 >= 1 || len2 >= 1; len1--, len2--) {
            int sum = carry;
            sum += (len1 >= 1) ? s1[len1 - 1] - '0' : 0;
            sum += (len2 >= 1) ? s2[len2 - 1] - '0' : 0;
            res.append(sum % 2);
            carry = sum / 2;
        }
        res.append(carry == 1 ? 1 : "");
        return res.reverse().toString();
    }
}
