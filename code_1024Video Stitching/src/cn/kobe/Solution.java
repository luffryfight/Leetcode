package cn.kobe;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 作用：dp还是难啊,感觉有点想贪心的思想
 * 2020/10/24
 */
public class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] limits = new int[T + 1];
        Arrays.fill(limits, 0);
        for (int[] ch : clips) {//获取极限
            int start = ch[0], end = ch[1];
            if (start < T)
                limits[start] = Math.max(limits[start], end);
        }
        if (limits[0] == 0) return -1;
        int count = 0, last = 0, pre = 0;
        for (int i = 0; i < T; i++) {
            last = Math.max(limits[i], last);
            if (i == last) return -1;
            if (i == pre) {
                count++;
                pre = last;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        Solution solution = new Solution();
        System.out.println(solution.videoStitching(clips, 10));
    }
}
