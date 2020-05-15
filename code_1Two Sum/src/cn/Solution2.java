package cn;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {//放入映射
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num=target-nums[i];
            if(map.containsKey(num)&&map.get(num)!=i){//不能重复利用
                return new int[]{i,map.get(num)};
            }
        }
         throw new IllegalArgumentException("No two sum solution");
    }
}
