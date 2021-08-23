package cn.kobe;

/**
 * @author 86137
 * @date 2021/7/8 17:49
 * TODO:  解法1从后向前遍历
 * 如果从左向右的话，332 就会出现 第一个符合条件，第二个不符合，然后第二位--，322，和前面的数又不合符了，所以倒着遍历。
 * 遇到 strs[i - 1] > strNum[i]的情况，让  strs[i - 1]--，然后strs[i]给为9，可以保证这两位变成最大单调递增整数。
 */
public class Solution2 {
    public int monotoneIncreasingDigits(int n) {
        char[] strs=String.valueOf(n).toCharArray();
        int len = strs.length-1;
        int flag=len;
        for (int i = len; i >0 ; i--) {
            if (strs[i] > strs[i - 1]) {
                flag=i;
                strs[i-1]--;
            }
        }
        for (int i = flag; i <= len; i++) {
            strs[i] = '9';
        }
        return Integer.parseInt(String.valueOf(strs));
    }
}
