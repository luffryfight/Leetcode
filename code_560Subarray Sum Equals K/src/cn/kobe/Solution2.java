package cn.kobe;

import java.util.HashMap;

/**
 * 作用：优化代码
 * 2020/10/13
 */
public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        //先计算前缀和，然后向前遍历前缀和
        //使用hashmap保存前缀和
        HashMap<Integer, Integer> map = new HashMap<>();
        //basecase
        map.put(0, 1);
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            if (map.containsKey(target)) {
                res += map.get(target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
