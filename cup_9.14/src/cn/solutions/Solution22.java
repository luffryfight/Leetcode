package cn.solutions;

import java.util.Arrays;

public class Solution22 {
    //双指针法
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int len1 = staple.length, len2 = drinks.length;
        int count = 0;
        boolean flag = true;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int i = 0, j = len2 - 1;
        while (i < len1 && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                count = (count + j + 1) % 1000000007;
                i++;
            } else j--;
        }
        return count % 1000000007;
    }
}
