package cn.kobe;

public class Solution2 {
    /*
     * 使用二分再优化一下
     * */
    public static int maxSideLength(int[][] mat, int threshold) {
        int row = mat.length, cul = mat[0].length;
        int[][] sum = new int[row + 1][cul + 1];
        int res = 0;
        //计算前缀和
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cul; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + mat[i][j];
            }
        }
        int l = 1, r = Math.min(row, cul);
        while (l <= r) {
            int mid = (l + r) / 2;
            boolean find = false;
            for (int i = 1; i <= row - mid + 1; ++i) {
                for (int j = 1; j <= cul - mid + 1; ++j) {
                    int r2 = row + mid - 1, c2 = cul + mid - 1;
                    if (sum[r2][c2] - sum[i - 1][c2] - sum[r2][j - 1] + sum[i + 1][j + 1] <= threshold) {
                        find = true;
                    }
                }
            }
            if (find) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
