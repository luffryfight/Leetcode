package cn.kobe;

public class Solution {
    /*
     * 动态规划：
     * 递归关系:
     * f(k)以A[k]结尾的结果，
     *        |2         A[k-2]<A[k-1] + 上行 || A[k-2]>A[k-1] + 下行
     *        |
     * f(k) = |f(k-1)+1  A[k-2]<A[k-1] + 下行 || A[k-2]>A[k-1] + 上行(波形)
     *        |
     *        |1         A[k-2]==A[k-1]
     * */
    public static int maxTurbulenceSize(int[] A) {
        if (A.length <= 1) return A.length;

        //定义dp数组:
        int[] dp = new int[A.length + 1];
        dp[0] = 0;
        dp[1] = 1;//处理边界

        int res = 0;
        int pre = A[0] < A[1] ? -1 : 1;//定义趋势：1上行，2下行
        for (int k = 2; k <= A.length; k++) {
            if ((A[k - 2] < A[k - 1] && pre == 1) || (A[k - 2] > A[k - 1] && pre == -1))
                dp[k] = 2;
            else if (A[k - 2] == A[k - 1])
                dp[k] = 1;
            else
                dp[k] = dp[k - 1] + 1;
            //更新趋势
            if (A[k - 2] == A[k - 1]) {
                pre = 0;
            } else {
                pre = A[k - 2] < A[k - 1] ? 1 : -1;
            }
            if (A.length - k + 3 < res && res > dp[k]) {//提前结束
                break;
            }
            res = Math.max(dp[k], res);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {92, 134, 98, 4, 183, 40, 103, 67, 35, 129, 196, 115, 2, 182,
                200, 166, 77, 181, 70, 84, 1, 55, 179, 80, 174, 37, 120,
                116, 156, 193, 15, 60, 44, 166, 9, 141, 64, 65, 12, 36};
        System.out.println(Solution.maxTurbulenceSize(nums));
    }
}
