package cn.kobe;

public class Solution {
    //感觉是深搜里较为简单的了
    boolean[][] visited;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    int row,col;
    int newColo;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        row=image.length;col=image[0].length;
        visited=new boolean [row][col];
        newColo=newColor;
        dfs(image,sr,sc,image[sr][sc]);
        return image;
    }
    private void dfs(int[][] image,int r,int c,int color){
        if(!isBorder(r,c)||visited[r][c]||image[r][c]!=color)
            return;
        visited[r][c]=true;
        image[r][c]=newColo;
        for(int[] ch:dir){
            int x=ch[0]+r,y=ch[1]+c;
                dfs(image,x,y,color);
        }
    }
    private boolean isBorder(int i,int j){
        return (i>=0&&i<row)&&(j>=0&&j<col);
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[][] nums={{1,1,1},{1,1,0},{1,0,1}};
        s.floodFill(nums,1,1,2);
    }
}
