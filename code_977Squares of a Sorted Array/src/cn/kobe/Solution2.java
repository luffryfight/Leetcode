package cn.kobe;

import java.util.Arrays;

/**
 * 作用：先用插入排序的方法把前面的排序一下  结果并不理想
 * 2020/10/16
 */
public class Solution2 {
    public int[] sortedSquares(int[] A) {
        //插入
        int temp = A[0];
        for (int i = 1; i < A.length; i++) {// -1 -4 0
            temp = A[i];
            int j;
            for (j = i; j > 0; j--) {
                if (Math.abs(A[j - 1]) >= Math.abs(temp)) {
                    A[j] = A[j - 1];
                } else break;
            }
            A[j] = temp;
        }
        //平方
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        Solution2 so = new Solution2();
        so.sortedSquares(nums);
    }
}
