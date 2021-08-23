package cn.kobe;

/**
 * to do : 参考最佳答案
 * 这其实也就是我想象中的代码。。。自己写出来也就。。
 * 但是我发现我自己的和这一样的时间，不管怎么说，这代码拉我三十条街
 *
 * @author 86137
 * @date 2021/4/21 18:37
 */
public class Max {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n == -1)
            return 1.0 / x;
        double t = 1;//注意t的使用，避免多次地鬼，也是就是剪枝！
        return (n & 1) == 1 ? (t = myPow(x, (n - 1) / 2)) * t * x : (t = myPow(x, n / 2)) * t;
    }

    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            if (n == -1) {
                return 1.0 / x;
            }
            if ((n & 1) == 1) {
                double t = myPow(x, (n - 1) / 2);
                return t * t * x;
            } else {
                double t = myPow(x, n / 2);
                return t * t;
            }
        }
    }
}
