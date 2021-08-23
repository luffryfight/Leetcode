package cn.kobe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 作用：练习Compartor接口
 * 2020/11/17
 */
public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[i * C + j] = new int[]{i, j};
            }
        }

        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(r0 - o1[0]) + Math.abs(c0 - o1[1])) -
                        (Math.abs(r0 - o2[0]) + Math.abs(c0 - o2[1]));
            }
        });
        return res;
    }
}
