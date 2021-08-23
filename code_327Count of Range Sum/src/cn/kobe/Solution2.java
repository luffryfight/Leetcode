package cn.kobe;

/**
 * 作用：试试用前缀和
 * 2020/11/7
 */
public class Solution2 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        long[] prefix = new long[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                long sum = prefix[i] - prefix[j];
                if (sum >= lower && sum <= upper)
                    res++;
            }
        }
        return countRangeSum(prefix, lower, upper, 0, nums.length - 1);

    }

    public int countRangeSum(long[] presum, int lower, int upper, int left, int right) {
        if (left == right) return 0;
        else {
            int mid = left + (right - left) / 2;
            int n1 = countRangeSum(presum, lower, upper, left, mid);
            int n2 = countRangeSum(presum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && presum[l] - presum[i] < lower) {
                    l++;
                }
                while (r <= right && presum[r] - presum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = (int) presum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = (int) presum[p1++];
                } else {
                    if (presum[p1] < presum[p2]) {
                        sorted[p++] = (int) presum[p1++];
                    } else {
                        sorted[p++] = (int) presum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                presum[left + j] = sorted[j];
            }
            return ret;
        }
    }
}
