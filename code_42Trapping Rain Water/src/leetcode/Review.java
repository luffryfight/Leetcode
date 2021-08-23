package leetcode;

import java.util.Stack;

/**
 * to do :双指针和单调栈方法！
 *
 * @author 86137
 * @date 2021/2/24 17:24
 */
public class Review {
    //左右边界法
    public int trap(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int left_Max = 0, right_Max = 0;
        int res = 0;
        while (left <= right) {
            if (left_Max <= right_Max) {
                res += (left_Max > height[left] ? left_Max - height[left] : 0);
                left_Max = Math.max(left_Max, height[left]);
                System.out.println(res + "" + left_Max);
                left++;
            } else {
                res += (right_Max > height[right] ? right_Max - height[right] : 0);
                right_Max = Math.max(right_Max, height[right]);
                right--;
            }
        }
        return res;
    }

    //栈
    public int trap2(int[] height) {
        if (height.length < 1) return 0;
        //stack保存下标是因为需要宽度！
        Stack<Integer> stack = new Stack();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int index = stack.pop();
                //弹出相等的栈顶元素，直到比index对应的值大
                while (!stack.isEmpty() && height[stack.peek()] == height[index]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {//不为空
                    //注意下面高度和宽度的计算
                    int wideth = i - stack.peek() - 1;//是当前的i
                    int high = Math.min(height[stack.peek()], height[i]) - height[index];
                    res += wideth * high;
                }
            }
            stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Review solution = new Review();
        System.out.println(solution.trap(arr));
    }
}
