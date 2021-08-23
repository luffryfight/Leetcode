package cn.kobe;

/**
 * 作用：学习题解
 * 快速幂算法：递归和迭代方法
 * 迭代的方法可以自己看看题解
 * 2020/11/19
 */
public class Solution2 {
    public double myPow(double x, int n) {
        return n > 0 ? dfs(x, n) : dfs(x, -n);
    }

    public double dfs(double x, int n) {
        if (n == 0) {//base case
            return 1;
        }
        double y = dfs(x, n / 2);
        return n % 2 == 0 ? y * y : x * y * y;
    }
}
