public class Solution2 {
    public static int maxArea(int[] height){//双指针法，可以对比第42题
        int l=0;
        int r=height.length-1;
        int max=0;
        int flag=0;
        while(l<r){//直接从两边收缩，
            int min=Math.min(height[l],height[r]);
            int cap=min*(r-l);
            if(cap>max){
                max=cap;
            }
            if(l<r&&height[l]<=height[r]){//先移动小的一边，尽量取大
                l++;
            }else
                --r;
        }
        return max;
    }
}
