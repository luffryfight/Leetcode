package cn.kobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0)
            return new int[]{};
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> res=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
                set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i]))
                res.add(nums2[i]);
        }
        int[] r=new int[res.size()];
        int index=0;
        for(int temp:res){
            r[index++]=temp;
        }
        return r;
    }
}
