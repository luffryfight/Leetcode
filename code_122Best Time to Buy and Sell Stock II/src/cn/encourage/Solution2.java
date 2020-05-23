package cn.encourage;

/*
*因该从这题的上一个类题做起
* */
public class Solution2 {
    public static int maxProfit(int[] prices){
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            int cha=prices[i]-prices[i-1];//两数之差
            if(cha>0)
                res+=cha;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] s={2,4,1};
        System.out.println(Solution2.maxProfit(s));
    }
}
