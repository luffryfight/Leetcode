package cn.kobe;

/**
 * 作用：
 * 2021/2/4
 */
public class Solution {
    public double findMaxAverage1(int[] nums, int k) {
        int len = nums.length;

        int left = 0, right = 0;
        int num = 0;
        double max = Integer.MIN_VALUE;
        while (right < len) {
            //更新
            int n = nums[right];
            num += n;
            if ((right - left + 1) >= k) {
                double temp = (double) num / k;
                if (temp > max)
                    max = temp;
                num -= nums[left];
                left++;
            }
            right++;
        }
        return max;
    }

    /**
     * 不用每次都计算平均值，只用在最后算一次
     */
    public double findMaxAverage2(int[] nums, int k) {
        int len = nums.length;

        int left = 0, right = 0;
        int num = 0, maxNum = Integer.MIN_VALUE;
        double max = Integer.MIN_VALUE;
        while (right < len) {
            //更新
            int n = nums[right];
            num += n;
            if ((right - left + 1) >= k) {
                if (num > maxNum)
                    maxNum = num;
                num -= nums[left];
                left++;
            }
            right++;
        }
        return (double) maxNum / k;
    }

    /**
     * 编程之美
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(sum, max);
        }

        return max * 1.0 / k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println();
        int[] arr = {1, 0, 1, 4, 2};
        System.out.println(solution.findMaxAverage(arr, 4));
    }
}
