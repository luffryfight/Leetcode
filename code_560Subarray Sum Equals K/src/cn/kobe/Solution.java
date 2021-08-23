package cn.kobe;

public class Solution {
    /**
     * 作用:练习前缀和
     *
     * @date 2020/10/13 16:52
     */
    public int subarraySum(int[] nums, int k) {
        //先计算前缀和，然后向前遍历前缀和
        int[] pre = new int[nums.length + 1];
        pre[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pre[i] - pre[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
