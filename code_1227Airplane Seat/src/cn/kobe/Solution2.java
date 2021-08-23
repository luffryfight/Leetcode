package cn.kobe;

public class Solution2 {
    /*
     * 规律就是1/2；
     * */
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1)
            return 1;
        return (double) 1 / 2;
    }
}
