package cn.review;

/*
满分答案！
* */
public class Solution4 {
    public static String decodeString(String s) {
        return dfs(s, 0)[1];
    }

    private static String[] dfs(String s, int i) {//字符串s和索引i,返回字符数组，索引i和结果string
        StringBuilder res = new StringBuilder();
        int multi = 0;//重复次数
        while (i < s.length()) {//没有走到结尾时
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {//是数字
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                //计算数字的值
            } else if (s.charAt(i) == '[') {//递归开启
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);//遇到']',i=结尾索引，即右括号位置
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']') {
                return new String[]{String.valueOf(i), res.toString()};
            } else {
                res.append(s.charAt(i));
            }
            i++;
        }
        return new String[]{String.valueOf(i), res.toString()};
    }
}
