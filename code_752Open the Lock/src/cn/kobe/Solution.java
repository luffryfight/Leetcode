package cn.kobe;

import java.sql.PreparedStatement;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution {
    /*
     * 还可以优化，从双向BFS入手，然后while开始时还可以再优化一步
     * */
    public int openLock(String[] deadends, String target) {
        //添加死亡数组
        Set<String> deads = new HashSet<>();
        for (String str : deadends) deads.add(str);
        //创建队列
        Queue<String> buckets = new ArrayDeque<>();
        //创建visited避免死循环
        Set<String> visited = new HashSet<>();
        buckets.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!buckets.isEmpty()) {
            int size = buckets.size();
            for (int i = 0; i < size; i++) {
                String cur = buckets.poll();
                if (deads.contains(cur)) continue;
                if (cur.equals(target)) return step;

                for (int j = 0; j < 4; j++) {
                    String upper = plusOne(cur, j);
                    if (!visited.contains(upper)) {
                        visited.add(upper);
                        buckets.offer(upper);
                    }
                    String lower = minusOne(cur, j);
                    if (!visited.contains(lower)) {
                        visited.add(lower);
                        buckets.offer(lower);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String str, int i) {
        char[] s = str.toCharArray();
        if (s[i] == '9')
            s[i] = '0';
        else
            s[i] += 1;
        return new String(s);
    }

    private String minusOne(String str, int i) {
        char[] s = str.toCharArray();
        if (s[i] == '0')
            s[i] = '9';
        else
            s[i] -= 1;
        return new String(s);
    }
}
