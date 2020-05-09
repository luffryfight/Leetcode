package leetcode268;

public class Solution2 {
    public static int missingNumber(int[] nums) {
        int res=nums.length*(nums.length+1)>>1;
        for(int temp:nums){
            res-=temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution2.missingNumber(new int []{10,9,6,4,2,3,5,7,0,1}));
    }
}
