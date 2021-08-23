package cn.kobe;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author 86137
 * @date 2021/7/11 16:52
 * TODO:
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return Integer.compare(o1[1],o2[1]);
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });
        int res=0;
        for(int i=0;i<points.length;i++){
            int end=points[i][1];
            while(i<points.length-1&& points[i+1][0]<=end){
                end=Math.min(points[i+1][1],end);
                i++;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][ ]arr={{0,9},{0,6}};
        Solution s =new Solution();
        s.findMinArrowShots(arr);
    }
}
