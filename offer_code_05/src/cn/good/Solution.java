package cn.good;

public class Solution {
    /*
     * 这道题注意，使用API不一定高效
     * */
    public String replaceSpace(String s) {
        if (s.equals("")) return s;
        int len = s.length();
        int kongge = 0;//统计空格个数
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') kongge++;
        }
        int r = len + kongge * 2;
        char[] str = new char[r];//取扩容

        while (len >= 0) {//遍历，从右
            char temp = s.charAt(--len);
            if (temp == ' ') {
                str[--r] = '0';
                str[--r] = '2';
                str[--r] = '%';
            } else {
                str[--r] = temp;
            }
        }
        return new String(str);
    }
}
