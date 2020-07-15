package cn.kobe;

import java.util.Arrays;

public class Solution2 {
    public static int[] intersection(int[] nums1, int[] nums2){
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
                while(l>0&&r>0&&(nums1[l-1]==nums2[r-1])&&nums1[l-1]==res[i-1]){
                    r--;l--;//去掉重复元素；和之前有道题类似
                }
            }else if(nums1[l-1]<nums2[r-1]){
                r--;
            }else{
                l--;
            }
        }
        return Arrays.copyOf(res,i);
    }

    public static void main(String[] args) {
        System.out.println(Solution2.intersection(new int[]{1,2},new int[]{2,1}));
    }
}
/*while(l>0&&r>0&&(nums1[l-1]==nums2[r-1])){
                    if(nums1[l-1]!=res[i-1])
                        break;
                    else {
                        r--;l--;
                    }
                }*/