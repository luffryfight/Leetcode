package cn.kobe;

import java.util.Arrays;

/**
 * 作用：复习
 * 1 3 5 3 2 1
 * 2021/2/5
 */
public class Review {
    //思路：从后往前找一个降序的数
    //这题直接看了之前的思路
    public void nextPermutation(int[] nums) {
        int index = -1, len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {//原数组降序
            Arrays.sort(nums);
            return;
        }
        for (int i = len - 1; i > index; i--) {
            if (nums[i] > nums[index]) {//找到比nums[index]大的数，然后交换
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        Arrays.sort(nums, index + 1, len);
    }
}
