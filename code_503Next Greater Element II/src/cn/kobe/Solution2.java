package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    //用单调栈做...不对啊
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] num = new int[n + n];
        //数组扩容
        System.arraycopy(nums, 0, num, 0, n);
        System.arraycopy(nums, 0, num, n, n);
        //结果数组
        int[] res = new int[n];
        int index = 0;
        //创建栈
        //处理最大值问题
        int max = Integer.MIN_VALUE;
        int imax = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length && index < n; i++) {
            while (!stack.isEmpty() && stack.peek() < num[i] && index < n) {
                res[index++] = num[i];//问题在这里，可能第三个才第一次遇到较大的，
                stack.pop();    // 直接index可能位置不对，所以需要保存下标
            }
            stack.push(num[i]);
            if (max < num[i]) {
                max = num[i];
                imax = i;
            }
        }
        res[imax] = -1;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 1, 2};
        System.out.println(Solution2.nextGreaterElements(arr));
    }
}
