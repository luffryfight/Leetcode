package cn.kobe;

/**
 * @author 86137
 * @date 2021/7/8 18:01
 * TODO: 数学方法！！！   100%  累加法 每次 + 11...11 超过就减少一个1
 */
public class Solution3 {
    public int monotoneIncreasingDigits(int n) {
        int max=111111111;
        int res=0;
        for (int i = 0; i < 9; i++) {
            while (res + max > n) {
                max/=10;
            }
            res+=max;
            if (max==0) break; //提前结束
        }
        return res;
    }
}
