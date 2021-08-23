package cn.kobe;

/**
 * to do : 注意本题有两个进阶题
 *
 * @author 86137
 * @date 2021/2/22 17:21
 */
public class Solution {
    //遍历出去第一列第一排的元素
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
