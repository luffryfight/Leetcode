import java.lang.reflect.Array;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 作用：暴力枚举我是肯定不会用的，但是我觉得排序是Nlog(N)  我想要N
 * 结果还真有，，
 * 2020/10/26
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] newarray = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            newarray[i] = nums[i];
        }
        Arrays.sort(newarray);
        map.put(newarray[0], 0);//base case
        for (int i = 1; i < len; i++) {
            if (newarray[i] == newarray[i - 1])
                continue;
            map.put(newarray[i], i);
        }
        for (int i = 0; i < len; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }

    public static void main(String[] args) {
        int m = 1, n = 0;
        n = (m--) + (++m) + ++m;
        System.out.println(m);
    }
}
