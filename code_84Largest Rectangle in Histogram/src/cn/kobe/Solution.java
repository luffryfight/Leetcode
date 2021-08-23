package cn.kobe;

public class Solution {
    /*
     * 第一感觉是双指针
     * */
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        //定高，确定宽
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i - 1;
            int right = i + 1;
            //下面两个循环来确定宽
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            while (right < heights.length && heights[right] >= heights[i]) {
                right++;
            }
            maxArea = Math.max(maxArea, (right - left - 1) * heights[i]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.println(Solution2.largestRectangleArea(nums));
    }
}
