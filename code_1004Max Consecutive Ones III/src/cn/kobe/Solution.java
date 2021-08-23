package cn.kobe;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/2/19 15:52
 */
public class Solution {
    //暴力遍历，超时
    //例45 330ms
    public int longestOnes0(int[] A, int K) {
        int len = A.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int temp = 0, k = K;
            for (int j = i; j < len; j++) {
                if (A[j] == 0 && k == 0) {
                    break;
                } else if (A[j] == 0) {
                    k--;
                }
                temp++;
            }
            max = Math.max(max, temp);
        }
        return max;
    }

    //暴力优化-->勉强通过，5%
    //例45 109ms
    public int longestOnes(int[] A, int K) {
        int len = A.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int temp = 0, k = K;
            for (int j = i; j < len; j++) {
                if (A[j] == 0 && k == 0) {
                    break;
                } else if (A[j] == 0) {
                    k--;
                }
                temp++;
            }
            while (i < len - 1 && A[i] + A[i + 1] == 2) i++;
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        Solution solution = new Solution();
        System.out.println(solution.longestOnes0(arr, 2));
    }
}
