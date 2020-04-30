public class Solution {
    public static int[][] imageSmoother(int[][] M) {
        //四个角，四条边
        int length=M.length; int width=M[0].length;
        int [][]res=new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int count=0;
                for (int l = i-1; l <= i+1; l++) {
                    for (int r = j-1; r <= j+1; r++) {
                        if(l>=0&&l<length&&r>=0&&r<width){
                            res[i][j]+=M[l][r];
                            count++;
                        }
                    }
                }
                res[i][j]/=count;
            }
        }
        return  res;
    }
}
