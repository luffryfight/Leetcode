package cn.kobe;

import sun.java2d.pipe.AAShapePipe;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    //从数字本身来理解
    //比如 1 2 5 4 1 要下一个更大的数就要将2 位置变更成更大的数(从后面找) 交换两个数
    //然后再把 1 4 5 2 1 中的 5 2 1排序 就是了
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;

        boolean flag = false;//判断是否是降序,降序就P排序
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) continue;
            flag = true;
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) --j;
            //交换
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            Arrays.sort(nums, i + 1, nums.length);
            break;//然后就结束
        }
        if (!flag) //降序的
            Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] s = {1, 3, 2, 15};
        Solution.nextPermutation(s);
    }

    /*
    * [1,1,1,2,5,6]
      [1,1,2,5,6,1]
    * */
}
