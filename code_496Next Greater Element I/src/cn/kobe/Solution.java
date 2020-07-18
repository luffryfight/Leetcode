package cn.kobe;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*直接遍历*/
        int[] res=new int[nums1.length];
        int index=0;
        for (int ch:nums1) {
            res[index++]=isFind(ch,nums2);
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
