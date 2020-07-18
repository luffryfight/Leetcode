package cn.kobe;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    /*
    * 扩大两倍，然后先按自己的方式做，再用单调栈
    * 不用hashmap，因为有重复元素
    * 做着做着就成暴力解法了
    * */
    public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] num=new int[n+n];
        //数组扩容
        System.arraycopy(nums,0,num,0,n);
        System.arraycopy(nums,0,num,n,n);

        int[] res=new int[n];
        int index=0;
        for (int ch:nums) {
            res[index++]= isFind(ch,num,index);
        }
        return res;
    }
    private static int isFind(int num,int[] n2,int start){
        for (int i=start;i<n2.length;i++) {
            if(num<n2[i])
                return n2[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,3,4,1,2};
        System.out.println(Solution.nextGreaterElements(arr));
    }
}
