package cn.kobe;

public class Solution2 {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n + 1];
        return count(boxes, 0, n - 1, 0, dp);
    }

    private int count(int[] boxes, int start, int end, int t, int[][][] dp) {
        if (start > end)
            return 0;
        if (dp[start][end][t] > 0)
            return dp[start][end][t];
        while (start < end && boxes[start] == boxes[start + 1]) {
            start++;
            t++;
        }
        int ans = (t + 1) * (t + 1) + count(boxes, start + 1, end, 0, dp);
        for (int i = start + 1; i <= end; i++) {
            if (boxes[i] == boxes[start])
                ans = Math.max(ans
                        , count(boxes, start + 1, i - 1, 0, dp)
                                + count(boxes, i, end, t + 1, dp));
        }
        dp[start][end][t] = ans;
        return ans;
    }
}
