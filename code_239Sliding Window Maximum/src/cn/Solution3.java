package cn;

import java.util.ArrayDeque;

public class Solution3 {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int[] nums;

    public void clean_queue(int index, int k) {
        //除去窗口之外的索引
        if (!queue.isEmpty() && index - k == queue.getFirst()) {//index-k==queue.getFirst说明不在窗口了
            queue.removeFirst();
        }
        //从尾去掉最小的
        while (!queue.isEmpty() && nums[index] > nums[queue.removeLast()]) {
            queue.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) return new int[0];
        if (k == 1) return nums;

        this.nums = nums;
        int index = 0;
        //入队前k个
        for (int i = 0; i < k; i++) {
            clean_queue(i, k);
            queue.addLast(i);
            if (nums[i] > nums[index]) index = i;//保存最大下标
        }
        int[] res = new int[len - k + 1];
        //res[0]=nums[index];
        for (int i = k; i < len; i++) {
            clean_queue(i, k);
            queue.addLast(i);
            res[i - k + 1] = queue.getFirst();
        }
        return res;
    }
}
