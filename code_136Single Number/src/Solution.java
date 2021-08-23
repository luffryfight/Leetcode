public class Solution {
    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int temp : nums) {
            num ^= temp;
        }
        return num;
    }
}
