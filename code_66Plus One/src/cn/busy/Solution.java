package cn.busy;

public class Solution {
    public static int[] plusOne(int[] digits) {//int数组更好处理
        int len = digits.length - 1;
        for (int i = len; i >= 0; --i) {
            if (i == len)//最后一个+1
                digits[i]++;
            if (digits[i] == 10 && i > 0) {
                digits[i - 1]++;
                digits[i] %= 10;
            } else if (i > 0)
                digits[i] %= 10;
        }
        if (digits[0] == 10) {
            int[] a = new int[len + 2];
            a[0] = 1;
            digits[0] = 0;
            System.arraycopy(digits, 0, a, 1, len);
            return a;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(Solution.plusOne(arr));
    }
}
