package cn.kobe;

import java.util.Arrays;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2){
        if(nums1.length==0||nums2.length==0)
            return new int[]{};
        Arrays.sort(nums1);Arrays.sort(nums2);
        int l=nums1.length,r=nums2.length;
        int[] res=new int[Math.max(l,r)];
        int i=0;
        while(l>0&&r>0){
            if(nums1[l-1]==nums2[r-1]){
                res[i++]=nums1[l-1];
                r--;l--;
            }else if(nums1[l-1]<nums2[r-1]){
                r--;
            }else{
                l--;
            }
        }
        return Arrays.copyOf(res,i);
    }
    public static void main(String[] args) {
        System.out.println(Solution.intersect(new int[]{1,2,2,1},new int[]{2,2}));
    }
}
