package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution4 {
    //用单调栈做...保存索引
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        //结果数组
        int[] res=new int[n];
        int index=0;
        //创建栈
        Deque<Integer> stack= new ArrayDeque<>();
        for (int i = 0; i < 2*n; i++) {
            while(!stack.isEmpty()&&nums[stack.peek()%n]<=nums[i%n]) {
                stack.pop();
            }
            res[i%n]=stack.isEmpty()?-1:nums[stack.peek()%n];
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={6,2,3,4,1,2};//1,2,1
        System.out.println(Solution3.nextGreaterElements(arr ));
    }
}
