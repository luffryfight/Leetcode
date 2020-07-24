package cn.kobe;

public class Solution {
    //直接暴力会超时
    public static int countDigitOne(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                if (temp % 10 == 1) {
                    num++;
                }
                temp /= 10;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(Solution.countDigitOne(13));
    }
}
