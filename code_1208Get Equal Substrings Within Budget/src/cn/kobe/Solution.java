package cn.kobe;

/**
 * 作用：
 * 2021/2/5
 */
public class Solution {
    //跟着思路走就行，就这？
    public int equalSubstring(String s, String t, int maxCost) {
        char[] str1 = s.toCharArray(), str2 = t.toCharArray();
        int len = s.length();
        int left = 0, right = 0;
        //结果
        int res = 0, consume = 0;
        while (right < len) {
            int temp = Math.abs(str1[right] - str2[right]);
            consume += temp;
            if (consume <= maxCost) {
                res = Math.max(right - left + 1, res);
            }
            right++;
            while (consume > maxCost) {
                consume -= Math.abs(str1[left] - str2[left]);
                left++;
            }
        }
        return res;
    }
}
