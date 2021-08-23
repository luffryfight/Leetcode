package cn;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    public PriorityQueue<Integer> min_heap, max_heap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        min_heap = new PriorityQueue<>();
        max_heap = new PriorityQueue<>(Collections.reverseOrder());//大根堆不是系统默认实现
    }

    //加一个元素
    public void addNum(int num) {
        max_heap.add(num);
        min_heap.add(max_heap.poll());
        if (max_heap.size() < min_heap.size() - 1) {//保证min大于max
            max_heap.add(min_heap.poll());
        }
    }

    public double findMedian() {
        if (max_heap.size() == min_heap.size()) {
            return (max_heap.peek() + min_heap.peek()) * 0.5;//此处要转换成double
        } else {
            return min_heap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
