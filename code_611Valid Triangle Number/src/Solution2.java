import java.util.Arrays;

public class Solution2 {
    public static int triangleNumber(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 2; --i) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return count;
    }

}
