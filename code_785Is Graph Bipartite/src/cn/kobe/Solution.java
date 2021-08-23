package cn.kobe;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean isBipartite(int[][] graph) {
        //点的个数
        int num = graph.length;
        int row = num;
        //遍历
        for (int i = 0; i < row; i++) {
            //提前判断
            if (graph[i].length + 1 == num)
                return false;
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int[] arr = new int[num];
            for (int j = 0; j < graph[i].length; j++) {
                arr[graph[i][j]]++;
            }
            for (int j = 0; j < num; j++) {
                if (arr[j] == 0)
                    list1.add(j);
                else
                    list2.add(j);
            }
            //这里已经得到两个集合，然后判断；
            if (isTrue(list1, list2, graph))
                return true;
        }
        //全部结束后都没有符合的
        return false;
    }

    private static boolean isTrue(List<Integer> l1, List<Integer> l2, int[][] g) {
        for (int i = 0; i < g.length; i++) {
            //判断这个点在哪个集合
            int location = l1.contains(i) ? 1 : 2;
            //遍历这个点所连接的边，判断是不是在同一个集合
            for (int j = 0; j < g[i].length; j++) {
                int loca = l1.contains(g[i][j]) ? 1 : 2;
                if (location == loca)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(Solution.isBipartite(arr));
    }
}
