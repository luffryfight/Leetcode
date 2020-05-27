package cn.none;

public class Solution {
    /*
    * 发现规律：
    * 可以以左下角为基准，target小就i--，target就j++;
    * */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i=matrix.length-1,j=0;
        while (i>=0&&j<matrix[0].length) {
            if(target<matrix[i][j]){
                i--;
            }else if(target>matrix[i][j]){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
