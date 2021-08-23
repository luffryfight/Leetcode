public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp ^= nums[i];//异或，但是题目要求logN 所以用二分
        }
        return temp;
    }
}
