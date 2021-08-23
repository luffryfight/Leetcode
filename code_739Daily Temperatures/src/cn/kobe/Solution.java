package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    //因为刚做了 496|503. 下一个更大元素 I|II所以直接有感觉。。
    //单调栈做!因为要计算其天数，所以保存数组索引
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        //创建栈
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int ind = stack.pop();
                res[ind] = i - ind;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {//剩下几个最大的
            res[stack.pop()] = 0;
        }
        return res;
    }
}
