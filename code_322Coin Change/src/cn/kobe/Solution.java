package cn.kobe;

public class Solution {
    /*
    * 最优子结构问题：dp[i]是由子结构opj(遍历coins)
    *
    * 定义递归方程：
    *       | o i==0
    * dp[i]=|
    *       | min(dp[i-coins[0],dp[i-coins[1]....)+1
    * */
    public static int coinChange(int[] coins, int amount) {
        if(coins.length<=0) return 0;

        int[] dp=new int[amount+1];
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            dp[i]=amount+1;
        }
        for (int i = 0; i <= amount; i++) {
            for(int coin:coins){
                if(i-coin<0)continue;//不能break因为可能是无序的
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] nums={1,2,5,10};
        System.out.println(Solution.coinChange(nums,11));
    }
}
