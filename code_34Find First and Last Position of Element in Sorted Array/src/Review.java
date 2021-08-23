/**
 * 作用：
 * 2021/2/8
 */
public class Review {
    //简单思路：直接遍历，取要的左右
    public int[] searchRange2(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = 0;
        int flag = 0;
        while (right < len) {
            if (nums[right] == target && flag == 0) {
                left = right;
                flag = 1;
            }
            if (flag == 1 && nums[right] != target) {
                break;
            }
            right++;
        }
        return flag == 0 ? new int[]{-1, -1} : new int[]{left, right - 1};
    }

    //logn：先二分到等于target值的地方
    //然后左右扩展
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                while (left > 0 && nums[left] == nums[left - 1]) left--;
                while (right < len - 1 && nums[right] == nums[right + 1]) right++;
                return new int[]{left, right};
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
