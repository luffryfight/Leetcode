public class Solution {
    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x <= 3)
            return 1;
        long left = 1;
        long right = x / 2;
        while (left < right) {
            long mid = (right + left) / 2 + 1;
            if (mid * mid <= x) {
                left = mid;
            } else
                right = mid - 1;
        }
        Math.pow(x, 0.5);
        return (int) left;
    }
}
