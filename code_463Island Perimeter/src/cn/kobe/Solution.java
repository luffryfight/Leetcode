package cn.kobe;

/**
 * 作用：和岛屿的面积是一类题
 * 2020/10/30
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int perimeter=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    perimeter+=getPerimeter(i,j,grid);
                }
            }
        }
        return perimeter;
    }
    public int getPerimeter(int i,int j,int[][] grid){
        int count=0;
        if(i-1>=0)  count+= grid[i-1][j]==0?0:1;//左
        if(j-1>=0)  count+= grid[i][j-1]==0?0:1;//右
        if(i<grid.length-1)  count+= grid[i+1][j]==0?0:1;//下
        if(j<grid[0].length-1)  count+= grid[i][j+1]==0?0:1;

        return 4-count ;
    }
}
