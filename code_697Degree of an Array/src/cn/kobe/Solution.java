package cn.kobe;

import java.util.HashMap;
import java.util.Map;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/2/20 15:16
 */
public class Solution {
    //滑动窗口 本题要维持很多变量
    //本来以为又很多细节会错，结果一次通过，很惊讶
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int temp = 0;
        for (int i = 0; i < len; i++) {
            int v = map.getOrDefault(nums[i], 0);
            map.put(nums[i], v + 1);
            temp = Math.max(temp, v + 1);
        }
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        int[] max = {0, 0};
        Map<Integer, Integer> window = new HashMap<Integer, Integer>();
        while (right < len) {
            int v = window.getOrDefault(nums[right], 0);
            window.put(nums[right], v + 1);
            if (v + 1 > max[1]) {
                max[0] = nums[right];
                max[1] = v + 1;
            }
            while (max[1] == temp) {
                res = Math.min(res, right - left + 1);
                window.put(nums[left], window.getOrDefault(nums[left], 0) - 1);
                if (nums[left] == nums[right]) max[1]--;
                left++;
            }
            right++;
        }
        return res;
    }

    //比上面快了一丢丢
    public int findShortestSubArray2(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int temp = 0;
        for (int i = 0; i < len; i++) {
            int v = map.getOrDefault(nums[i], 0);
            map.put(nums[i], v + 1);
            temp = Math.max(temp, v + 1);
        }
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE, max = 0;
        Map<Integer, Integer> window = new HashMap<Integer, Integer>();
        while (right < len) {
            int v = window.getOrDefault(nums[right], 0);
            window.put(nums[right], v + 1);
            max = Math.max(max, v + 1);
            while (max == temp) {
                res = Math.min(res, right - left + 1);
                window.put(nums[left], window.getOrDefault(nums[left], 0) - 1);
                if (nums[left] == nums[right]) max--;//这里注意体会。。。。
                left++;
            }
            right++;
        }
        return res;
    }
}
