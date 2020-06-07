package cn.kobe;

public class Solution {
    /*
    * 题目连接：
    * https://atcoder.jp/contests/dp/tasks/dp_c
    * 从leetcode978的经验来看，是多子问题动态规划
    * 定义f1(k)为第k天的最大快乐指数，并且第k天是执行a计划，其他同理，res取最大值
    * 方程： f(k)=max(f2[k-1],f3[k-1])+a[k]
    * base case:
    * 都为0
    * */
    private static int vocation(int[] a,int[] b,int[] c){
        int n= a.length;
        //定义递归数组：
        int[] f1=new int[n+1];//a
        int[] f2=new int[n+1];//b
        int[] f3=new int[n+1];//c
        //base case:
        f1[0]=0;f2[0]=0;f3[0]=0;
        int res=0;
        for (int k = 1; k <= n; k++) {//k从1开始，注意边界
            f1[k]=Math.max(f2[k-1],f3[k-1])+a[k-1];
            f2[k]=Math.max(f1[k-1],f3[k-1])+b[k-1];
            f3[k]=Math.max(f2[k-1],f1[k-1])+c[k-1];
            res=Math.max(f1[k],Math.max(f2[k],f3[k]));
        }
        return res;
    }
}
