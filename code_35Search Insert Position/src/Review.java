/**
 * 作用：
 * 2021/2/8
 */
public class Review {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            System.out.println(mid);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] >= target ? left : left + 1;
    }
}
