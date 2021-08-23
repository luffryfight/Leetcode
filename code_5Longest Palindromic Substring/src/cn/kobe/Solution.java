package cn.kobe;

class Solution {
    private char[] preProcess(String s) {
        //特殊情况
        int len = s.length();
        if (len == 0)
            return new char[]{'^', '$'};
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for (char ch : s.toCharArray()) {
            sb.append('#').append(ch);
        }
        sb.append("#$");
        return sb.toString().toCharArray();
    }

    public String longestPalindrome(String s) {

        char[] str = preProcess(s);
        int[] pLen = new int[str.length];
        int c = 0, r = 0;//r为半径
        for (int i = 1; i < str.length - 1; i++) {
            int j = 2 * c - i;//左边，
            if (r > i) {
                pLen[i] = Math.min(r - i, pLen[j]);//防止超出R，就是这一步快进了很多
            } else {//只能是r==i
                pLen[i] = 0;//为下面的中性扩展的写法提供方便
            }
            while (str[i + 1 + pLen[i]] == str[i - 1 - pLen[i]])
                pLen[i]++;
            if (i + pLen[i] > r) {
                r = i + pLen[i];
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
