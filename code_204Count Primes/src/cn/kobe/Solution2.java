package cn.kobe;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 作用：标记一个质数的x*x不是质数
 * 2020/12/3
 */
public class Solution2 {
    public int countPrimes(int n) {
        int[] isPrim = new int[n];
        Arrays.fill(isPrim, 1);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i] == 1) {
                ++res;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {//i的倍数赋值
                        isPrim[j] = 0;//这个循环会有重复
                    }
                }
            }
        }
        return res;
    }
}
