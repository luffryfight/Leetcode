package cn.it;

public class Solution3 {
    /*
     * 时间：1.5N
     * */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) return;
        //简化k
        k %= len;
        revers(nums, 0, len - 1);
        revers(nums, 0, k - 1);
        revers(nums, k, len - 1);
    }

    //反转从i到j位置的元素
    public static void revers(int[] nums, int i, int j) {//i,j为索引
        int len = (i + j + 1) / 2;//向上取整
        for (; i < len; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Solution3.rotate(nums, 6);
        for (int ch : nums) {
            System.out.print(ch + " ");
        }
    }
}
