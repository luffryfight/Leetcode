package cn.none;

public class Solution {
    //和26题类似
    /*
     * 当思路混乱时，有可能是第一步就错了
     * */
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        //使用双指针
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {//类似插入排序的过程
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(Solution.removeElement(nums, 2));
    }
}
