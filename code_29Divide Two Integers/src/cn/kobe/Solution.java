package cn.kobe;

/**
 * 作用：学习+复习！
 * 2021/2/4
 */
public class Solution {
    //思路感觉很简单，可以简单概括为： 60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7
    //上面的例子是摘抄的
    //学会把思路转换成代码！
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean flag = (dividend ^ divisor) < 0;

        int count = 0;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                count += 1 << i;//可以除尽的倍数，就加上 为结果
                a -= b << i;  // 注意是减去divisor 的2^i 倍
            }
        }
        return flag ? -count : count;
    }
}
