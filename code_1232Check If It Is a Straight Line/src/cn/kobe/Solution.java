package cn.kobe;

/**
 * 作用：如果相除直接算斜率可能会有错误
 * 换成相乘的形式
 * 进阶题:149题
 * 2021/1/17
 */
public class Solution {
    public boolean checkStraightLine(int[][] c) {
        //求斜率
        double k = 0;
        for (int i = 2; i < c.length; i++) {
            int[] ch = c[i];
            if ((ch[1] - c[0][1]) * (c[1][0] - c[0][0]) !=
                    ((c[1][1] - c[0][1]) * (ch[0] - c[0][0])))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        Solution solution = new Solution();
        System.out.println(solution.checkStraightLine(arr));
    }
}
