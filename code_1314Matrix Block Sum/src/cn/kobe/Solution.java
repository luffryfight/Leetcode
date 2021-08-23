package cn.kobe;

public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length, cul = mat[0].length;
        int[][] sum = new int[row + 1][cul + 1];
        //计算前缀和
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cul; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + mat[i][j];
            }
        }
        //赋值
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cul; j++) {
                //防止坐标越界
                int r1 = Math.max(i - K, 0);//左上角
                int c1 = Math.max(j - K, 0);

                int r2 = Math.min(i + K, row - 1);//右上角
                int c2 = Math.min(j + K, cul - 1);
                //这个公式就可以计算出，两点构成的矩形里的和
                mat[i][j] = sum[r2 + 1][c2 + 1] - sum[r1][c2 + 1] - sum[r2 + 1][c1] + sum[r1][c1];
            }
        }
        return mat;
    }
}
