package cn.solutions;

import java.util.Arrays;

public class Solution23 {
    //二分，遍历第一个数组，对第二个数组二分
    //就是把第一种解法优化了一下
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int len1 = staple.length, len2 = drinks.length;
        int count = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        for (int i = 0; i < len1; i++) {
            int index = getBinary(drinks, x - staple[i]);
            if (index == 0) break;
            count = (count + index) % 1000000007;
        }
        return count % 1000000007;
    }

    public int getBinary(int[] data, int target) {
        int i = 0, j = data.length;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (data[mid] > target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}
