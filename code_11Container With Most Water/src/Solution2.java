public class Solution2 {
    public static int maxArea(int[] height){
        int l=0;
        int r=height.length-1;
        int max=0;
        int flag=0;
        while(l<r){
            int min=Math.min(height[l],height[r]);
            int cap=min*(r-l);
            if(cap>max){
                max=cap;
            }
            if(l<r&&height[l]<=height[r]){
                l++;
            }else
                --r;
        }
        return max;
    }
}
