package cn.kobe;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/4/18 15:03
 */
public class Review {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] str1 = num1.toCharArray();
        char[] str2 = num2.toCharArray();
        //调换顺序
        //结果的长度最多为两长度的和
        int len = str1.length + str2.length;
        int[] res = new int[len];
        for (int i = str1.length - 1; i >= 0; i--) {
            for (int j = str2.length - 1; j >= 0; j--) {
                int num = (str1[i] - '0') * (str2[j] - '0'), index = (i + j) + 1;
                int n = num + res[index];
                res[index - 1] += n / 10;//进位
                res[index] = n % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len && res[i] == 0) i++;
        for (int j = i; j < len; j++) sb.append(res[j]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("20", "6"));
    }
}
