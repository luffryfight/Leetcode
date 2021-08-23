package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * to do :滑动窗口，在路上想到了的，回来又忘了
 *
 * @author 86137
 * @date 2021/2/19 16:03
 */
public class Solution2 {
    public int longestOnes(int[] A, int K) {
        int len = A.length;
        int max = 0;
        List<Integer> list = new ArrayList<>();
        int left = 0, right = 0;
        int k = K, temp = 0;
        while (right < len) {
            if (A[right] == 0) {
                k--;
            }
            temp++;
            right++;// 必须在收缩窗口前++，例子：{0，0，0，0} k=0

            while (k < 0 && left < right) {
                if (A[left] == 0) k++;
                temp--;
                left++;
            }
            max = Math.max(max, temp);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0};
        Solution2 solution = new Solution2();
        System.out.println(solution.longestOnes(arr, 0));
    }
}
