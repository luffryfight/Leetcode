package cn.kobe;

public class Solution {
    //学习了再来做的
    public int jump(int[] nums) {
        int end = 0, dis = 0;//dis 表示每一轮能到达的最远距离,end 等于是pre dis
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            dis = Math.max(dis, nums[i] + i);
            if (end == i) {
                res++;
                end = dis;
            }
        }
        return res;
    }
}
