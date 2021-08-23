package cn.kobe;

public class Solution3 {
    //已经学过的知识
    //去除最后一位的1
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }
}
