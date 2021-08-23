package cn.good;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] > nums[right]) {
            return left;
        }
        return right;
    }
}
