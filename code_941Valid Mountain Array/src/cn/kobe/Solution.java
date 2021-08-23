package cn.kobe;

/**
 * 作用：我觉得这种题就特别适合连手，以为要考虑细节问题，难又不难就是细节
 * 2020/11/3
 */
public class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int left = 0, right = A.length - 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1])
                left++;
            else break;
        }
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1])
                right--;
            else break;
        }
        if (left == 0 || right == A.length - 1)
            return false;
        return left == right;
    }
}
