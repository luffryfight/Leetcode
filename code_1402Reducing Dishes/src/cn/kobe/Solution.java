package cn.kobe;

import java.util.Arrays;

public class Solution {
    /*
     * 稀奇古怪的方法。。。。哭了
     * */
    public static int maxSatisfaction(int[] satisfaction) {
        if (satisfaction.length <= 0) return 0;
        int len = satisfaction.length;
        //先排序
        Arrays.sort(satisfaction);
        if (satisfaction[len - 1] <= 0) return 0;
        //找到>=的索引
        int i;
        int sum1 = 0, max = 0, base = 0;
        for (i = 0; i < len && satisfaction[i] < 0; i++) ;
        int car = 1;//递增的关系
        for (int j = i; j < len; j++) {
            sum1 += satisfaction[j] * (j - i + 1);//正数先加
            base += satisfaction[j];
        }
        max = sum1;
        int sum2 = 0;
        car = 1;
        for (int j = i - 1; j >= 0; j--, car++) {
            sum2 = result(satisfaction, j, i - 1);
            if (sum2 + sum1 + base * car >= max)
                max = sum2 + sum1 + base * car;
            else
                break;
        }
        return max;
    }

    public static int result(int[] nums, int i, int k) {
        int res = 0;
        for (int j = i; j <= k; j++) {
            res += nums[j] * (j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -8, 0, 5, -7};
        System.out.println(Solution.maxSatisfaction(nums));
    }
}
