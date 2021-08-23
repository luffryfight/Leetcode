package cn.kobe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 作用：不用集合，用set 同时排序，居然比解法1更快
 * 2020/10/28
 */
public class Solution2 {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> buckt = new HashSet<>();
        Arrays.sort(arr);//快排这么快嘛
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {//重新计数
                if (!buckt.add(count))
                    return false;
                count = 1;
            } else
                count++;
        }
        //最后一次的判断
        if (!buckt.add(count))
            return false;
        return true;
    }
}
