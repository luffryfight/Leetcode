public class Solution3 {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int num1 = 1;
        int num2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = num1 + num2;
            num1 = num2;
            num2 = temp;
        }

        return num2;
    }
}
