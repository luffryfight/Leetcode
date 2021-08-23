package cn.good;

/*
 * 看了官方给的解答
 * */
public class Solution2 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])//get
                return i;
        }
        return nums.length - 1;
    }
}

