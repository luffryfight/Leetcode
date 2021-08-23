public class Solution {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {//规律：最右边<最左边
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {//在小的部分
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else
                --right;
        }
        return nums[left];
    }
}
