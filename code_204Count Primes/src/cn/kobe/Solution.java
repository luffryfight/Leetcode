package cn.kobe;

/**
 * 作用：https://blog.csdn.net/u014339020/article/details/79817094 回顾之前看过的一些额外知识
 * 2020/12/3
 * 这个超时
 */
public class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int res = 2;
        for (int i = 4; i < n; i++) {
            if (i % 6 != 5 && i % 6 != 1) continue;
            boolean flag = false;
            for (int k = 2; k * k < i; k++) {
                if (i % k == 0) {
                    System.out.println(i);
                    flag = true;
                    break;
                }
            }
            res += (flag == true ? 0 : 1);
        }
        return res;
    }
}
