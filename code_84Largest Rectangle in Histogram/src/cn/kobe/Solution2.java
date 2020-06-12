package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public static int largestRectangleArea(int[] heights){
        int len=heights.length;
        if(len==1) return heights[0];
        else if(len==0) return 0;
        //加两个边界
        len+=2;
        int[] temp=new int[len];
        System.arraycopy(heights,0,temp,1,len-2);
        temp[0]=0;temp[len-1]=0;

        int res=0;
        Deque<Integer> stack=new ArrayDeque<>();
        stack.add(0);//加入做边界
        for (int i = 1; i < len; i++) {
            while(temp[i]<temp[stack.peekLast()]){
                int height=temp[stack.pollLast()];
                int wideth=i-stack.peekLast()-1;
                res=Math.max(res,height*wideth);
            }
            stack.add(i);
        }
        return res;
    }
}
