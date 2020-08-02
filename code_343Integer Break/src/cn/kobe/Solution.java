package cn.kobe;

public class Solution {
    /*虽然做了很久，但是是自己做出来的，nice*/
    public int integerBreak(int n) {
        int[] dp=new int[n+2];
        dp[0]=0;dp[1]=1;
        for(int i=2;i<=n;i++){
            if(i>3&&i<7){
                double x=i/2;
                dp[i]=(int)Math.ceil((i-x)*x);
            }else{
                for(int j=1;j<=(i+1)/2;j++){
                    dp[i]=Math.max(dp[i],j*dp[i-j]);
                }
            }
        }
        /*debug
        * 但是为啥会占那么多时间，这个debug
        * */
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]+" ");
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution so=new Solution();
        for (int i = 2; i < 7; i++) {
            System.out.println(so.integerBreak(i));
        }
    }
}
