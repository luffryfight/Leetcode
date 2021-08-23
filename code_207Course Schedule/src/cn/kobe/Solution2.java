package cn.kobe;

import java.util.*;

public class Solution2 {
    //保存相邻节点
    List<List<Integer>> list = new LinkedList<>();
    //标志节点,每个节点存在3种状态
    int[] visited;
    int valid = 0;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>();
        visited = new int[numCourses];
        //加入n个节点
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {//遍历，加入相邻节点
            list.get(pre[1]).add(pre[0]);
            visited[pre[0]]++;//pre[0]是被指向了的节点
        }
        Deque<Integer> queue = new ArrayDeque<>();
        //初始化入队
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            valid++;
            for (int n : list.get(queue.poll())) {
                visited[n]--;
                if (visited[n] == 0)
                    queue.offer(n);
            }
        }
        return valid == numCourses;
    }

}
