package cn.encourage;

/*
 * 垃圾版本
 * */
public class Solution {
    public static int maxProfit(int[] prices) {
        int left = 0, right = 1;
        int res = 0;
        int max = prices[0];
        int flag = 0;//指定谁先移动
        while (right < prices.length && left <= right) {
            if (prices[left] > prices[right]) {//移动左指针
                left = right;
                max = prices[left];
            } else {
                flag = 0;
            }

            if (prices[right] >= max) {
                max = prices[right];
                if (right == prices.length - 1)
                    res += max - prices[left];
            } else {
                flag = 1;
                res += prices[right - 1] - prices[left];
                left = right - 1;
                max = prices[right];
            }
            if (flag == 0) right++;
            else left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] s = {2, 4, 1};
        System.out.println(Solution.maxProfit(s));
    }
}
