package cn.busy;

public class Solution {
    public static int maxAreaOfIsland(int[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length; i++) {//遍历每个元素
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){//没有被访问过的陆地
                    res=Math.max(res,sumAround(grid,i,j));
                }
            }
        }
        return res;
    }
    public static int sumAround(int[][] arr,int i,int j){//当前陆地的周围，（深度）
        if(isInland(arr,i,j)==false||arr[i][j]!=1){//不在范围内，且不是没被去过的陆地
            return 0;
        }
        //需要标记是否走过
        arr[i][j]=2;
        return 1+sumAround(arr,i-1,j)+sumAround(arr,i+1,j)+sumAround(arr,i,j+1)+sumAround(arr,i,j-1);
    }
    //是否在数组范围内
    public static boolean isInland(int[][] arr,int i, int j){
        return i>=0&&i<arr.length&&j>=0&&j<arr[0].length;
    }

    public static void main(String[] args) {
        int[][] a={{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(Solution.maxAreaOfIsland(a));
    }
}
