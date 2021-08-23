package cn.kobe;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /*
     * 6.29打卡题，排序，堆！队列，
     * */
    /*public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }*/
    //使用堆API
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int temp : nums) {//包子堆中只有k个元素
            heap.add(temp);
            Arrays.sort(nums);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();//最后的堆中，堆顶就是第K个
    }
}
