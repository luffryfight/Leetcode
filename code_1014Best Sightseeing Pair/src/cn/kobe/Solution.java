package cn.kobe;

public class Solution {
    /*
    * 读题就知道显然是dp
    * 首先定义一个性价比是A[i]-i
    * 定义dp[i]是到i时前面最大的性价比
    *
    * 注意题目里的i和j有顺序要求，不然就会做错。。
    * */
    /*
    然后本题 关系是只与上一项有关，可以空间优化
    * */
    public static int maxScoreSightseeingPair(int[] A) {
        int len = A.length;//8,1,5,2,6
        int[] dp=new int[len+1];
        int res=0;
        dp[0]=0;
        for (int i = 1; i <= len; i++) {
            int temp=A[i-1]-(i-1);
            res=Math.max(res,temp+dp[i-1]);
            dp[i]=Math.max(A[i-1]+(i-1),dp[i-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={8,1,5,10,9};
        System.out.println(Solution.maxScoreSightseeingPair(nums));
    }
}
