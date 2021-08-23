package cn.kobe;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
    /*自己做题时都有一点这个思路的，但是确实自己第一次实现这种会有点难度*/
    //堆来维护下一个读取的数时min
    public int[] smallestRange(List<List<Integer>> nums) {
        int left = 0, right = Integer.MAX_VALUE;
        int minRange = right - left;
        int len = nums.size();
        //创建指针数组
        int[] next = new int[len];
        //创建堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return nums.get(i).get(next[i]) - nums.get(j).get(next[j]);
            }
        });
        int max = Integer.MIN_VALUE;
        //初始化堆，即加入每个链表的第一个元素
        for (int i = 0; i < len; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        //结束条件是：有一个列表被遍历完了，即可以获得题意
        while (true) {
            int minIndex = priorityQueue.poll();
            int getNum = nums.get(minIndex).get(next[minIndex]);
            int currange = max - getNum;
            System.out.println(getNum + "  " + max + "--" + currange);
            if (currange < minRange) {
                minRange = currange;
                left = getNum;
                right = max;
            }
            next[minIndex]++;
            //此处为优化点，往后寻找小于max的最大元素，直接跳到它
            while (next[minIndex] + 1 < nums.get(minIndex).size() && nums.get(minIndex).get(next[minIndex] + 1) <= max) {
                next[minIndex]++;
            }
            if (next[minIndex] == nums.get(minIndex).size())
                break;
            priorityQueue.offer(minIndex);
            //是Index++后的max
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{left, right};
    }
}
