package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/5/5 15:58
 */
public class Review {
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
                System.out.println(w);
                res=Math.max(res,h*w);
            }
            stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Review review=new Review();
        int[] heights={2,1,5,6,2,2,2,3};

        System.out.println(review.largestRectangleArea(heights));
    }
}
