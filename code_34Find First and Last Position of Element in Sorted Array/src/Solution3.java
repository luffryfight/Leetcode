/**
 * 作用：再练习练习二分，
 * 2020/12/1
 */
public class Solution3 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1)
            return new int[]{-1, 1};
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = right = mid;
                while (left > 0 && nums[left - 1] == target) left--;
                while (right < nums.length - 1 && nums[right + 1] == target) right++;
                return new int[]{left, right};
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (left == right && nums[left] == nums[right]) {
            return new int[]{left, right};
        }
        return new int[]{-1, 1};
    }

    public static void main(String[] args) {
        System.out.println(7 / 2);
    }
}
