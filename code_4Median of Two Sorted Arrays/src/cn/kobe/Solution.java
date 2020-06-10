package cn.kobe;

public class Solution {
    /*
    * 本题难点：一：读懂题意，中位数是可以讲两个数组都分为两部分。。。。（有点难描述）；
    * 开始主要是没读懂题，后面静下心来，读懂了其实也还好，
    * 关键点：①中位数两边数组长度相等，②left(max)<right(min);...
    * ...官方和其他题解真的很清楚了。。
    *
    * base case:
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //我们规定第一个数组的长度较小！
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length,n=nums2.length;

        int midres1=0,midres2=0;
        //本质就是对nums1中的索引进行二分
        int left=0,right=m;
        while(left<=right){
            int mid=(left+right)/2;
            int mid_j=(m+n+1)/2-mid;//nums2数组中对应的索引

            int max1=(mid==0?Integer.MIN_VALUE:nums1[mid-1]);
            int min1=(mid==m?Integer.MAX_VALUE:nums1[mid]);
            int max2=(mid_j==0?Integer.MIN_VALUE:nums2[mid_j-1]);
            int min2=(mid_j==n?Integer.MAX_VALUE:nums2[mid_j]);

            //判断i
            if(max1<=min2){//nums1[mid-1]<=nums2[mid]
                midres1=Math.max(max1,max2);
                midres2=Math.min(min2,min1);
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return (m+n)%2==0?(midres1+midres2)/2.0:midres1;
    }
}
