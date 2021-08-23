package cn.kobe;

/**
 * 作用：复习
 * 2021/1/26
 */
public class Review {
    //我就要正着做
    //只要注意题目说的int的范围，既然不能乘，那就÷
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res + (x % 10) / 10 > 2147483647 / 10 || res + (x % 10) / 10 < -2147483648 / 10) {//超出整数的范围
                return 0;
            } else
                res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
