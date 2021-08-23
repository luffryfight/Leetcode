package cn.kobe;

public class Solution3 {
    //暴力的优化
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i)
                return i;
            if (nums[i] > i + 1) {
                i = nums[i] - 1;
            }
        }
        return -1;
    }
}
