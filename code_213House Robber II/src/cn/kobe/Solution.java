package cn.kobe;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        //根据上一题的题解，求出从0 n-1 和1 到n
        //只可能有三种不同情况：要么都不被抢；
        // 要么第一间房子被抢最后一间不抢；要么最后一间房子被抢第一间不抢。
        //然后中间部分都在其他情况种
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, res = 0, temp;
        for (int ch : nums) {
            temp = res;
            res = Math.max(pre + ch, res);
            pre = temp;
        }
        return res;
    }
}
