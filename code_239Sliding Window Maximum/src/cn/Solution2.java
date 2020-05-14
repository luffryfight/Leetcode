package cn;

public class Solution2 {
    public static int[] maxSlidingWindow(int[] nums, int k){
        int len=nums.length;
        if(len==0||k==0)return new int[0];
        int []res=new int[len-k+1];//因为索引要+1
        for (int i = 0; i < len - k; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = 0; j < i+k; j++) {
                max=Math.max(max,nums[j]);
            }
            res[i]=max;
        }
        return res;
    }
}
