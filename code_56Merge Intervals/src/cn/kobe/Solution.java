package cn.kobe;

import sun.awt.OSInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 作用：自己做出来了，虽然只有10ms，而且自己没使用idea编程
 * 但是模拟面试还是差一点就写出来了
 * <p>
 * 2021/4.25
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        /*Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });*/
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int index = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (list.size() < 1) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                continue;
            }
            int[] temp = list.get(list.size() - 1);
            if (temp[1] < intervals[i][0]) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                int min = Math.min(intervals[i][0], temp[0]);
                int max = Math.max(intervals[i][1], temp[1]);
                list.remove(list.size() - 1);
                list.add(new int[]{min, max});
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] ch = list.get(i);
            res[i][0] = ch[0];
            res[i][1] = ch[1];
        }
        return res;
    }
}
