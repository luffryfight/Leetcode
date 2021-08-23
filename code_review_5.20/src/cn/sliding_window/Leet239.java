package cn.sliding_window;

import java.util.ArrayDeque;

public class Leet239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] res = new int[len - k + 1];
        int index = -1, max = 0;
        for (int i = 0; i < len - k + 1; i++) {
            if (index >= i) {
                if (nums[k + i - 1] > max) {
                    max = nums[k + i - 1];
                    index = k + i - 1;
                }
            } else {
                max = nums[i];
                for (int j = i + 1; j < i + k; j++) {
                    if (nums[j] > max) {
                        max = nums[i];
                        index = j;
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }

}

class Solution {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int[] num;

    public void clear(int index, int k) {
        if (!queue.isEmpty() && index - queue.getFirst() == k - 1) {
            queue.removeFirst();
        }
        while (!queue.isEmpty() && num[index] > num[queue.getLast()]) {
            queue.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        num = nums;
        int len = nums.length;
        int maxindex = 0;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            clear(i, k);
            queue.addLast(i);
            if (nums[i] > nums[maxindex]) maxindex = i;
        }
        //第一个先存进去
        res[0] = nums[maxindex];
        for (int i = k; i < len; i++) {
            clear(i, k);
            queue.addLast(i);
            res[i - k + 1] = nums[queue.getFirst()];
        }
        return res;
    }
}
