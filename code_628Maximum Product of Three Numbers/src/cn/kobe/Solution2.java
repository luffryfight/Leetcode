package cn.kobe;

/**
 * 作用：
 * 2021/1/20
 */
class Solution2 {
    public int maximumProduct(int[] nums) {
        int last1 = Integer.MAX_VALUE, last2 = Integer.MAX_VALUE;
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        int n = nums.length;
        for (int t : nums) {
            if (t > first) {
                third = second;
                second = first;
                first = t;
            } else if (t > second) {
                third = second;
                second = t;
            } else if (t > third) {
                third = t;
            }
            if (t < last1) {
                last2 = last1;
                last1 = t;
            } else if (t < last2) {
                last2 = t;
            }
        }
        return Math.max(last1 * last2 * first, first * second * third);
    }
}
