import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxcount = 0;
        int maxnum = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            if (count >= maxcount) {
                maxnum = nums[i];
                maxcount = count;
            }
            map.put(nums[i], count);
        }
        return maxnum;
    }
}
