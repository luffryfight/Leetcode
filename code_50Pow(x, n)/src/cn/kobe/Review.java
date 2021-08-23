package cn.kobe;

/**
 * to do : 301 / 304   ->  304/304
 * 最后几个真就特殊情况没考虑到。。。然后一次次提交
 * 这叫快速幂法  还有个叫快速幂+迭代
 *
 * @author 86137
 * @date 2021/4/21 18:21
 */
public class Review {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        if (n < 0) {
            return 1 / get2N(x, -n);
        }
        return get2N(x, n);
    }

    public double get2N(double x, int n) {
        double pre = x;
        if (n == 1) return x;
        if (n == 2) return x * x;
        int count = 1;
        while (count * 2 < n) {
            x *= x;
            count *= 2;
        }
        if (count == n) {
            return x;
        } else {
            return x * get2N(pre, n - count);
        }
    }

    public static void main(String[] args) {

        for (int i = 10; i < 100; i++) {
            System.out.println(Math.pow(1.0000001, i));
        }
        System.out.println(Math.pow(2, 1000));
        System.out.println(Math.pow(1.0000001, 1.2323123123));
    }
}
