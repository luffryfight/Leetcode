package cn.kobe;

/**
 * 作用：
 * 2021/2/1
 */
public class Solution {
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    //官方题解三：对模串计算哈希
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;
        char[] str1 = haystack.toCharArray(), str2 = needle.toCharArray();
        int a = 26;//倍数
        long modulus = (long) Math.pow(2, 31);

        long h = 0, ref_h = 0;//哈希值
        for (int i = 0; i < L; i++) {
            h = (h * a + getValue(str1, i)) % modulus;
            ref_h = (ref_h * a + getValue(str2, i)) % modulus;
        }
        if (h == ref_h) return 0;//从第一个开始就匹配了

        long aL = 1;//获取取模数
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; start++) {
            //移除窗口第一个字符的哈希值,再计算新加字符的哈希
            h = (h * a - getValue(str1, start - 1) * aL + getValue(str1, start + L - 1)) % modulus;
            if (h == ref_h) return start;
        }
        return -1;
    }

    public int getValue(char[] str, int index) {
        return (int) str[index] - (int) 'a';
    }
}
