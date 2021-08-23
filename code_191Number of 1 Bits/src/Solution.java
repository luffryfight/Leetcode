public class Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
//        for (int i = 0; i < 32; i++) {
////            count+=(n>>i)&1;
////        }
        while (n > 0) {
            count += (n & 1);
            n >>= 1;//比n&=n-1;慢，因为这个是一位一位的
        }
        return count;
    }
}
