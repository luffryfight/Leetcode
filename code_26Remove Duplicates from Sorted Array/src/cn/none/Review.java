package cn.none;

/**
 * 作用：原地算法
 * 2021/2/1
 */
public class Review {
    public int removeDuplicates(int[] nums) {
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[flag]) {
                nums[flag + 1] = nums[i];
                flag++;
            }
        }
        return flag + 1;
    }
}
