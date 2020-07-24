package cn.kobe;

public class Solution2 {
    //对每一位的1进行判断，每一位1有三种情况
    public int countDigitOne(int n) {
        int count = 0;
        //num=pre`k`next
        for (long k = 1; k <= n; k *= 10) {
            long pre = n / k, next = n % k;//+8是为了进位（比如取2时)
            count += (pre + 8) / 10 * k + (pre % 10 == 1 ? next + 1 : 0);
        }

        return count;
    }
}
