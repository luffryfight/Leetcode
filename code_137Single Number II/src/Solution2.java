public class Solution2 {
    public int singleNumber(int[] nums){
        int a=0,b=0;
        for(int temp:nums){
            b=(b^temp)&~a;
            a=(a^temp)&~b;
        }
        return b;
    }
}
