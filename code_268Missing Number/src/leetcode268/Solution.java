package leetcode268;

public class Solution {
    public static int missingNumber(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i]^i;//有相同的数就会抵消，剩下答案，
        }
        return res^nums.length;//上面遍历没有遍历num.length
    }

    public static void main(String[] args) {
        System.out.println(Solution.missingNumber(new int []{9,6,4,2,3,5,7,0,1}));
    }
}
