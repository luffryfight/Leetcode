package cn.it;

public class Solution {
    /*
    * 汗水版：差点超时
    * */
    public static void rotate(int[] nums, int k) {
        if(nums.length<=1) return;

        int temp=nums[0];
        while(k-->0){//移动k次，每次移动一位
            for (int i = 1; i < nums.length; i++) {
                nums[0]=nums[i];
                nums[i]=temp;
                temp=nums[0];
            }
        }

    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        Solution.rotate(nums,3);
        for(int ch:nums){
            System.out.print(ch);
        }
    }
}
