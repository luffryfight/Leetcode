package leetcode;

import java.util.PrimitiveIterator;

public class Solution {
    public int trap(int[] height) {
        int left = 0;
        int leftmax = 0, rightmax = 0;
        //定义左右两边的界限，每次从界限小的一边的计算满足条件的
        int right = height.length - 1;
        int res = 0;//计算满足条件时的每个元素上值，依次计算
        while (left <= right) {
            if (leftmax >= rightmax) {//此时右边就可以res+=
                res += (rightmax > height[right] ? rightmax - height[right] : 0);
                rightmax = Math.max(height[right], rightmax);
                --right;
            } else {//左边同理
                res += (leftmax > height[left] ? leftmax - height[left] : 0);
                leftmax = Math.max(height[left], leftmax);
                ++left;
            }
        }
        return res;
    }
}
