package cn.kobe;

public class Solution2 {
    //因为数组是有序的，可以二分
    public int findMagicIndex(int[] nums) {
        return find(nums,0,nums.length-1);
    }
    private int find(int[] arr,int l,int r){
        if(l>r)
            return -1;
        int mid=(l+r)>>1;
        int res=find(arr,l,mid-1);
        if(res!=-1)
            return res;
        else if(arr[mid]==mid)
            return mid;
        return find(arr,mid+1,r);
    }
}
