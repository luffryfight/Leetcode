package code_268;

public class Solution {
    public static int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Solution.getSum(20, 10));
        int a = 10;
        int b = 30;
        swap(a, b);
        qufan(a);
    }

    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }

    public static void qufan(int a) {
        a = a + (~a);
        System.out.println(a);
    }
}
