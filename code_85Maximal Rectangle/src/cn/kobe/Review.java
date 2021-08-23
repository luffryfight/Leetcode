package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/5/5 18:35
 */
public class Review {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length<1) return 0;
        int[] heights=new int[matrix[0].length];
        int res=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }else{
                    heights[j]=0;
                }
            }
            res=Math.max(res,largestRectangleArea(heights));
        }

        return largestRectangleArea(heights);
    }
    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        if(len==1) return heights[0];
        else if(len==0) return 0;
        //加两个边界
        len+=2;
        int[] temp=new int[len];
        System.arraycopy(heights,0,temp,1,len-2);
        temp[0]=0;temp[len-1]=0;

        Deque<Integer> stack=new ArrayDeque<>();
        int res=0;
        stack.add(0);
        for(int i=1;i<len;i++){
            while(temp[stack.peekLast()]>temp[i]){
                int h=temp[stack.pollLast()];
                int w=i-stack.peekLast()-1;
                res=Math.max(res,h*w);
            }
            stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Review review=new Review();
        char[][] arrs={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(review.maximalRectangle(arrs));
    }
}
