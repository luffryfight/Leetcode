package cn.pass;

import java.util.Arrays;
import java.util.HashMap;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/4/20 21:36
 */
public class Review {
    //看了原来的代码。。。
    public void rotate(int[][] matrix) {

        int len = matrix.length;
        //翻转两次 先是上下堆着，然后对角线
        if (len == 1) return;

        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = temp;
            }
        }
        new HashMap<>().keySet();
        //对角线
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
