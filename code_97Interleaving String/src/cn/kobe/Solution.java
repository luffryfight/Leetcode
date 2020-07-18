package cn.kobe;

public class Solution {
    //记忆数组
    boolean[][] dp;
    //转换
    char[] str1;
    char[] str2;
    char[] str3;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
         str1=s1.toCharArray();
         str2=s2.toCharArray();
         str3=s3.toCharArray();
         dp=new boolean[s1.length()+1][s2.length()+1];
        return dfs(0,0,0);
    }
    private boolean dfs(int i1,int i2,int i3){
        //结束条件
        if(i3==str3.length)
            return true;
        if(dp[i1][i2])//已经访问过了
            return false;
        char ch=str3[i3];
        //很清晰了，但是自己写的时候又会不容易想到
        if(i1<str1.length&&ch==str1[i1]&&dfs(i1+1,i2,i3+1))
            return true;
        if(i2<str2.length&&ch==str2[i2]&&dfs(i1,i2+1,i3+1))
            return true;
        dp[i1][i2]=true;
        return false;
    }
}
