package cn.kobe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //图掌握得还是不太行！
    //①深度遍历,格式其实挺固定的


    //保存相邻节点
    List<List<Integer>> list = new LinkedList<>();
    //标志节点,每个节点存在3种状态
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>();
        visited = new int[numCourses];
        //加入n个节点
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {//遍历，加入相邻节点
            list.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int numNode) {//visit[i]的状态定义才是精髓
        visited[numNode] = 1;
        for (int v : list.get(numNode)) {//遍历相邻节点
            if (visited[v] == 0) {
                dfs(v);
                if (!valid)
                    return;
            } else if (visited[v] == 1) {//成环状
                valid = false;
                return;
            }
        }
        visited[numNode] = 2;//已经可以达到的节点
    }
}
