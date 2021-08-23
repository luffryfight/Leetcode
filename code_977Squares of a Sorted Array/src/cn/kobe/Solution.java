package cn.kobe;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 作用：
 * 2020/10/16
 */
public class Solution {
    //每个数平方后再排序
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
