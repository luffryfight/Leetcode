package cn;

import java.lang.reflect.Array;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 作用：复习
 * 方法：双指针
 * 排序后依次移动指针
 * 2021/1/19
 */
public class Review {
    //暴力枚举
    /*public int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int num=nums[i]+nums[j];
                if (num==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }*/

    //记忆法
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{0, 0};
    }

}
