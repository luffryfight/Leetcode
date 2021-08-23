package cn.kobe;

import java.util.Map;

/**
 * 作用：
 * 2020/10/25
 */
public class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int l = 0;
        int res = 0;
        while (l < A.length) {
            int next = getNext(l, A);
            if (next <= l) return res;

            if (l == 0 && A[l] >= A[l + 1]) {
                l = next;
                continue;
            }
            res = Math.max(res, next - l + 1);
            l = next;
        }
        return res;
    }

    public int getNext(int index, int[] A) {
        for (int i = index + 1; i < A.length; i++) {
            if (i == A.length - 1) {
                if (A[i] < A[i - 1])
                    return i;
            } else if (A[i] < A[i + 1] && A[i] < A[i - 1])
                return i;
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] array={2,1,4,7,3,2,5,6,7,8,9,7,5,4,8};
        //[9,8,7,6,5,4,3,2,1,0]
        int[] array = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(solution.longestMountain(array));
    }
}
