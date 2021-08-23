package cn.kobe;

/**
 * 作用：
 * 2021/2/7
 */
public class Solution {
    //注意几个特殊情况
    //尽量使a[i]变小, 因为a[i+1]变大, 会影响后面数组的判断
    public boolean checkPossibility(int[] nums) {
        int min = -100000, len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 1 && count < 2; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i != 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
                count++;
            }
        }
        //判断是否非递减
        return count <= 1;
    }
}
