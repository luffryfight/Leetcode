package cn.kobe;

import java.util.Map;

public class Solution2 {
    //空间优化版本
    //本题其实就可以利用原数组，来看代码！
    public static int minPathSum(int[][] grid){
        int m=grid.length,n=grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j!=0){
                    grid[i][j]+=grid[i][j-1];
                }else if(j==0&&i!=0){
                    grid[i][j]+=grid[i-1][j];
                }else if(i!=0&&j!=0)
                    grid[i][j]+= Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
