package cn.nothing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/4/24 17:01
 */
public class Review {
    List<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] state = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(state[i], 0);
        }
        int i = 0, j = 0;
        while (i < n && j < m) {
            while (j < m - 1 && state[i][j] == 0) {
                res.add(matrix[i][j++]);
                state[i][j - 1] = 1;
            }
            while (i < n - 1 && state[i][j] == 0) {//向下
                res.add(matrix[i++][j]);
                state[i - 1][j] = 1;
            }
            while (j > 0 && state[i][j] == 0) {
                res.add(matrix[i][j--]);
                state[i][j + 1] = 1;
            }
            while (i > 0 && state[i][j] == 0) {
                res.add(matrix[i--][j]);
                state[i + 1][j] = 1;
            }
            i++;
            j++;
        }
        return res;
    }


    public static void main(String[] args) {
        Review review = new Review();
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        review.spiralOrder(nums);
    }
}
