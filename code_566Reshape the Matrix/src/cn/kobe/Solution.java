package cn.kobe;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/2/17 18:15
 */
public class Solution {
    //注意二维坐标对一维的转换
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, cul = nums[0].length;
        if (row * cul != r * c)
            return nums;

        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / cul][i % cul];
        }
        return res;
    }
}
