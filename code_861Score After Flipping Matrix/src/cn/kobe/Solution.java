package cn.kobe;

/**
 * 作用：感觉都是模拟，主要看你怎么做
 * 2020/12/7
 * [0,0,1,1], ->[1,1,1,1],
 * [1,0,1,0], ->[1,0,0,1],
 * [1,1,0,0], ->[1,1,1,1],
 */
public class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        //先从行来看，若每行第一个是0就翻转，
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = A[i][j] == 1 ? 0 : 1;//反转
                }
            }
        }
        //然后从第二列开始看，
        for (int i = 1; i < n; i++) {
            //计算每一列中1的个数
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (A[j][i] == 1) {
                    A[j][i] = 0;
                    count++;
                } else
                    A[j][i] = 1;
            }
            if (count > m - count) {//再次反转回来，也就是不反转
                for (int j = 0; j < m; j++) {
                    A[j][i] = A[j][i] == 1 ? 0 : 1;//反转
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = n - 1; j >= 0; --j) {
                res += A[i][j] * (Math.pow(2, n - 1 - j));
            }
        }
        return res;
    }
}
