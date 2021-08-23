public class Solution2 {
    static int mypow(int x, double y) {
        if (y == 0) {
            return 1;
        }
        if (y == 1) {
            return x;
        }
        int result = 0;
        int tmp = mypow(x, y / 2);
        if (y % 2 != 0) //奇数
        {
            result = x * tmp * tmp;
        } else {
            result = tmp * tmp;
        }
        return result;
    }
}
