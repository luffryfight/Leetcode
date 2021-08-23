package cn.kobe;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 作用：Prim算法：
 * 和一开始自己的思路其实很类似，
 * 每次都选择最短距离的点（贪心的性质了）
 * 只不过要不断更新剩下节点到已经访问过节点的集合的最短距离
 * 2021/1/19
 */
public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[][] dis = new int[points.length][points.length];//保存点与点之间的距离
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distence = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);
                dis[i][j] = distence;
                dis[j][i] = distence;
            }
        }
        int start = 0;//默认从0开始计算
        int[] node = new int[points.length];//保存节点
        Arrays.fill(node, 0);//0 未访问
        node[start] = -1;//标记已经访问过

        int[] cost = new int[points.length];//最小花费  -1 表示已经计算过
        for (int i = 1; i < points.length; i++) {
            cost[i] = dis[i][start];//从0点开始
        }

        //遍历得出结果
        for (int i = 1; i < points.length; i++) {
            int minIndex = 0;
            ;
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < points.length; j++) {
                if (node[j] != 0) continue;//已经访问过,则跳过
                if (minCost > cost[j]) {
                    minCost = cost[j];
                    minIndex = j;
                }
            }
            //更新
            node[minIndex] = -1;
            cost[minIndex] = -1;
            res += minCost;
            //更新最短距离
            for (int j = 0; j < points.length; j++) {
                if (node[j] == 0 && dis[minIndex][j] < cost[j]) {//没放过的点
                    cost[j] = dis[minIndex][j];
                }
            }
        }
        return res;
    }
}
