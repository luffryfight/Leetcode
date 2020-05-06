public class Solution {
    public static int totalHammingDistance(int[] nums) {
        int len=nums.length;
        if(len<=1){
            return 0;
        }
        int []bit=new int[32];
        for (int num:nums) {
            for (int j = 0; j < 32; j++) {
                bit[j]+=(num>>j)&1;
                if(num==0){
                    break;
                }
            }
        }
        bit[0]=bit[0]*(len-bit[0]);
        for (int i = 1; i < 32; i++) {
            if(bit[i]!=0)
                bit[0]+=bit[i]*(len-bit[i]);
        }
        return bit[0];
    }
}
