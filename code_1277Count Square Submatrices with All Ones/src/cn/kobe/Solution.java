package cn.kobe;

public class Solution {
    /**
     * 做完后可以继续练习221
     **/
    public static int countSquares(int[][] matrix) {
        int ans = 0;
        //等于累加的效果
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                //这个状态方程简单
                if (matrix[i][j] == 0) continue;
                else if (i == 0 || j == 0) ans++;
                else {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                    ans += matrix[i][j];
                }
            }
            /*for(int i = 0 ; i < matrix.length ; i++){
                for(int j = 0 ; j < matrix[0].length ; j++){
                    System.out.print(matrix[i][j]+" ");
                    }
                System.out.println();
                }*/
        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(Solution.countSquares(arr));
    }
}
