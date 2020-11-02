package cn.kobe;

/**
 * 作用：递归求解
 * 重点就是如何带入计算在周长
 * 向四个方向遍历当遇到边界时和水时就返回1
 * 2020/10/30
 */
public class Solution2 {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int perimeter=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    return perimeter=dfs(grid,i,j);
                }
            }
        }
        return 0;//没有岛屿就返回0
    }
    public int dfs(int[][] grid,int i,int j){
        if (!(0 <= i && i < grid.length && 0 <= j && j < grid[0].length))
            return 1;
        if (grid[i][j]==0)
            return 1;
        else if (grid[i][j]!=1)//已经遍历过的就返回
            return 0;
        grid[i][j]=2;
        return dfs(grid,i-1,j)+dfs(grid,i,j-1)
                +dfs(grid,i+1,j)+dfs(grid,i,j+1);
    }
}
