package cn.kobe;

import java.util.HashMap;
import java.util.HashSet;

public class Solution2 {
    /*显然第一种方式太慢了*/
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        //尝试用hashmap,遍历次数会少很多
        HashMap<Integer,Integer> map=new HashMap<>();
        //从n2中得到对应结果
        for (int i = 0; i < nums2.length; i++) {
            int index=i+1,temp=-1;
            while(index<nums2.length){
                if(nums2[index]>nums2[i]){
                    temp=nums2[index];break;
                }
                index++;
            }
            map.put(nums2[i],temp);
        }
        //处理结果
        int[] res=new int[nums1.length];
        int index=0;
        for(int ch:nums1){
            res[index++]=map.get(ch);
        }
        return res;
    }
    private int isFind(int num,int[] n2){
        int index=0;
        int res=0;
        for (int ch:n2) {
            if(index==1&&num<ch)
                return ch;
            if(ch==num)
                index=1;
        }
        return -1;
    }
}
