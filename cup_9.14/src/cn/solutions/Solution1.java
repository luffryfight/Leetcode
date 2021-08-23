package cn.solutions;

public class Solution1 {
    public int calculate(String s) {
        int sum = 0;
        //转换成字符数组
        int x = 1, y = 0;
        char[] str = s.toCharArray();
        for (char ch : str) {
            if (ch == 'A') {
                x = getA(x, y);
            } else {
                y = getB(x, y);
            }
        }
        return x + y;
    }

    public int getA(int x, int y) {
        return 2 * x + y;
    }

    public int getB(int x, int y) {
        return x + 2 * y;
    }
}
