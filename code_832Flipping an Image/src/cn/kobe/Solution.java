package cn.kobe;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/2/24 16:41
 */
public class Solution {
    //本题思路就是安装题意坐
    //可以两次循环，一次翻转，但是我就要一次
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length, cul = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= cul / 2; j++) {
                if (j == cul / 2 && (cul & 1) == 0) continue;
                int temp = A[i][j] == 1 ? 0 : 1;
                A[i][j] = A[i][cul - 1 - j] == 1 ? 0 : 1;
                A[i][cul - 1 - j] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        Solution solution = new Solution();
        System.out.println(solution.flipAndInvertImage(arr));
    }
}
