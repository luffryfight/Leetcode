package cn.kobe;

import java.util.ArrayList;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/4/19 14:26
 */
public class Review {
    ArrayList<Double> list = new ArrayList<>();


    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int indexMax = 0;//每次跳跃能到达的最大位置
        int res = 0;
        for (int i = 0; i < nums.length; ) {
            res++;
            indexMax = Math.max(indexMax, i + nums[i]);
            if (indexMax >= nums.length - 1) return res;//提前判断

            int nextIndex = i;
            for (int j = i + 1; j <= nums[i] + i && j < nums.length; j++) {
                int newPos = j + nums[j];
                if (newPos > indexMax) {
                    indexMax = newPos;
                    nextIndex = j;
                }
            }
            i = nextIndex;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 1, 1, 4};
        System.out.println(jump(num));
    }
}
