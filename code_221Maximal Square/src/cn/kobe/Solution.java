package cn.kobe;

public class Solution {
    /**
     * 做完可以接着练习下1277
     **/
    //本题需要注意一些特殊情况
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1)
            return matrix[0][0] - '0';
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    continue;
                else if (i == 0 || j == 0)
                    res = Math.max(res, matrix[i][j] - '0');
                else {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1],
                            Math.min(matrix[i - 1][j], matrix[i][j - 1])) - '0';
                    res = Math.max(res, matrix[i][j] - '0');
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        System.out.println('1' - '0');
    }
}
