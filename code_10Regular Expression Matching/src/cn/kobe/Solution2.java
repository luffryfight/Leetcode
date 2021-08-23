package cn.kobe;

public class Solution2 {
    public static boolean isMatch(String s, String p) {
        //递归结束条件
        if (p.length() == 0) return s.length() == 0;
        char[] s2 = s.toCharArray();
        char[] p2 = p.toCharArray();

        int i = 0, j = 0;
        boolean match;
        while (i < s.length()) {
            if (j >= p2.length) return false;
            //处理’.‘
            match = (p2[j] != '.' ? s2[i] == p2[j] : true);
            //处理’*‘
            if (p.length() - 1 > j && p2[j + 1] == '*') {//跳过这两个字符或者匹配之后比较下一个
                if (match) i++;//匹配了
                else j += 2;
            } else {
                if (match) {
                    i++;
                    j++;
                } else return false;
            }
        }
        if (p.length() - 1 > j && p2[j] == '.' && p2[j + 1] == '*') {//'.*+x'结尾
            j += 2;
        } else if (p.length() - 1 > j && p2[j + 1] == '*')
            j += 2;
        return j == p2.length;
    }

    public static void main(String[] args) {
        System.out.println(Solution2.isMatch("aaa", "a*"));
    }
}
