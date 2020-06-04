package cn.kobe;

import java.net.Socket;

public class Solution {
    /*
    * 第一种，类似滑动窗口的思想,，，，还是得复习
    * */
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length<=0) return 0;
        int l=0,r=0;
        int sum=0,res=Integer.MAX_VALUE;
        while(r<nums.length){
            sum+=nums[r];
            r++;
            while(sum>=s){
                res=Math.min(res,r-l);
                sum-=nums[l];
                l++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(Solution.minSubArrayLen(11,nums));
    }
}
