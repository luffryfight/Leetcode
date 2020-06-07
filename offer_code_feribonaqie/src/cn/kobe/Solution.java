package cn.kobe;

public class Solution {
    /*
    * 动态规划做了一圈回来找自信
    * */
    public static int fib(int n) {
        if(n<=1) return  n;

        int pre=1,cur=1;
        int temp=0;
        for (int i = 2; i < n; i++) {
            temp=(pre+cur)%1000000007;//注意这个处理，题目要求
            pre=cur;
            cur=temp;
        }
        return cur%1000000007;
    }

    public static void main(String[] args) {
        System.out.println(Solution.fib(2));
    }
}
