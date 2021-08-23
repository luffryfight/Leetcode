package cn.pass;

public class Solution {
    /*
     * 旋转两次，一次对折，一次对角线对折
     * */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //上下对折
        for (int i = 0; i < len / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[len - i - 1];
            matrix[len - i - 1] = temp;
        }
        //之后再沿对角线对折
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {//只需要遍历一半
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
