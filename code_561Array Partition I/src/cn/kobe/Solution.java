package cn.kobe;

import java.util.Arrays;
import java.util.HashMap;

/**
 * to do : 简单
 *
 * @author 86137
 * @date 2021/2/16 20:53
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] culs = new HashMap[9];
        HashMap<Integer, Integer>[] boxs = new HashMap[9];


        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;

    }
}
