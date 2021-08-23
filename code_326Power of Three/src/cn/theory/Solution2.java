package cn.theory;

public class Solution2 {
    public boolean isPowerOfThree(int n) {
        //3^19=1162261467,只要是3的次幂就可以被n整除
        return n > 0 && 1162261467 % n == 0;
    }
}
