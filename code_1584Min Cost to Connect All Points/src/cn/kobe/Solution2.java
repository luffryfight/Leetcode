package cn.kobe;

import java.util.Arrays;

/**
 * 作用：优化
 * 2021/1/19
 */
public class Solution2 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        int res = 0;//结果

        for (int i = 0; i < n; i++) {
            //找到最小边
            int minIndex = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dis[minIndex] > dis[j]) {
                    minIndex = j;
                }
            }
            //更行结果
            visited[minIndex] = true;//标记为已经访问过了
            if (dis[minIndex] != Integer.MAX_VALUE) {
                res += dis[minIndex];
            }
            //更新加权边
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    dis[j] = Math.min(dis[j], calDistence(points[minIndex], points[j]));
                }
            }
        }
        return res;
    }

    public int calDistence(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
}
