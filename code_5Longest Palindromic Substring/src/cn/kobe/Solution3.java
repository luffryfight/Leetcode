package cn.kobe;

public class Solution3 {
    //数学方法max
    //原理推荐看官方题解
    public int scoreOfParentheses(String S) {
        int level = 0;
        int res = 0;
        //转换成数组
        char[] str = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            if (str[i] == '(')
                level++;
            else {
                level--;
                if (str[i - 1] == '(')
                    res += 1 << level;
            }
        }
        return res;
    }
}
