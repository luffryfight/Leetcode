package cn.kobe;

public class Solution {
    /*
    * 桶排序:也没有排序啦，只是统计每个数字的个数，然后再加到新数组上
    * */
        public void sortColors(int[] nums) {
            if(nums.length<=1) return;
            //创建桶
            int[] bucket=new int[3];
            //统计
            for (int i = 0; i < nums.length; i++) {
                bucket[nums[i]]++;
            }
            //添加
            int index=0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < bucket[i]; j++) {
                    nums[index++]=i;
                }
            }
        }

    /*
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了6.67%的用户
     * */
}
