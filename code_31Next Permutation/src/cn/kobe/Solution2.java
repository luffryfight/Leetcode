package cn.kobe;

import java.util.Arrays;

/**
 * 作用：暴力法就是获取所有排列，然后比较
 * <p>
 * 2020/11/10
 */
public class Solution2 {//5,4,3,2,1

    public void nextPermutation(int[] nums) {
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[index] < nums[i]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        //交换i,
        Arrays.sort(nums, index + 1, nums.length);

    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 2, 5, 4, 1};
        solution.nextPermutation(nums);
        System.out.println(nums);
    }
}
