public class Solution2 {
    public int sumNums(int n) {
        int ans = 0, A = n, B = n + 1;
        boolean flag;
        int count = 14;
        while (count-- > 0) {//可以展开，就是14个，懒得写
            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;
        }
        return ans >> 1;
    }
}
