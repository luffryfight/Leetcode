package cn.kobe;

public class Solution2 {
    //有两条定理，然后就可以懂，可以用马拉车算法
    //结论一：s 中长度为 prefix.size() 的后缀 suffix 和 prefix 是互为翻转的。
    //结论二：s 中长度为 s.size() - prefix.size() 的前缀本身就是回文的。
    private char[] getProcess(String str) {
        int len = str.length();
        if (len == 0) {
            return new char[]{'^', '$'};
        }
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for (char ch : str.toCharArray()) {
            sb.append('#').append(ch);
        }
        sb.append("#$");
        return sb.toString().toCharArray();
    }

    private String longestPalindrome(String s) {
        char[] str = getProcess(s);
        //保存之前的结果
        int[] pLen = new int[str.length];
        int c = 0, r = 0;
        for (int i = 1; i < str.length - 1; i++) {
            int iTemp = 2 * c - i;
            if (i < r) {
                pLen[i] = Math.min(r - i, pLen[iTemp]);
            } else {//i==r
                pLen[i] = 0;
            }
            while (str[i + 1 + pLen[i]] == str[i - 1 - pLen[i]]) {
                pLen[i]++;
            }
            //判断是否越界
            if (pLen[i] + i > r) {
                r = pLen[i] + i;
                c = i;
            }
        }
        int maxlen = 0;
        int index = 0;
        for (int i = 0; i < pLen.length; i++) {
            if (pLen[i] > maxlen) {
                maxlen = pLen[i];
                index = i;
            }
        }
        int start = (index - maxlen) / 2;//原字符串中的位置
        return s.substring(start, start + maxlen);
    }
}
