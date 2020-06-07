package cn.kobe;

public class Solution {
    /*
    * 先做1314题再来这道题
    * */
    public static int maxSideLength(int[][] mat, int threshold) {
        int row=mat.length,cul=mat[0].length;
        int[][] sum=new int[row+1][cul+1];
        int res=0;
        //计算前缀和
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cul; j++) {
                sum[i+1][j+1]=sum[i+1][j]+sum[i][j+1]-sum[i][j]+mat[i][j];
            }
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= cul; j++) {
                for(int k=1;k<=i&&k<=j;k++){//边长从1开始
                    //获取左上角坐标
                    int r1=i-k,c1=j-k;
                    int temp=sum[i][j]-sum[i][c1]-sum[r1][j]+sum[r1][c1];
                    if(temp<=threshold){
                        res=Math.max(res,k);
                    }else break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res={{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        System.out.println(Solution.maxSideLength(res,4));
    }
}
