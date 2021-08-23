package cn.kobe;

import org.omg.CORBA.MARSHAL;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution2 {
    /*这个可以优化一下，但是总体思路差不多，我就不改了*/
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int ch : nums1) {
            if (map1.containsKey(ch))
                map1.put(ch, map1.get(ch) + 1);
            else
                map1.put(ch, 1);
        }
        for (int ch : nums2) {
            if (map2.containsKey(ch))
                map2.put(ch, map2.get(ch) + 1);
            else
                map2.put(ch, 1);
        }
        int[] res = new int[nums1.length + nums2.length];
        int index = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int ch : nums1) {
            int num = 0;
            if (map1.containsKey(ch) && map2.containsKey(ch) && !set.contains(ch))
                num = Math.min(map1.get(ch), map2.get(ch));
            for (int i = 0; i < num; i++) {
                res[index++] = ch;
            }
            set.add(ch);
        }
        return Arrays.copyOf(res, index);
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        System.out.println(Solution2.intersect(num1, num2));
    }
}
