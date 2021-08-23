package cn.solutions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution2 {
    /*果然超时*/
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int len1 = staple.length, len2 = drinks.length;
        int count = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        boolean flag = true;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (staple[i] + drinks[j] > x) {
                    break;
                }
                count = (count + 1) % 1000000007;
            }
        }
        return count % 1000000007;
    }
}
