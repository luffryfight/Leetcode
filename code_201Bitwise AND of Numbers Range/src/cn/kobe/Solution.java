package cn.kobe;

public class Solution {
    //我就知道直接遍历肯定不行
    public int rangeBitwiseAnd(int m, int n) {
        int res = n;
        for (int i = m; i < n; i++) {
            res &= i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.rangeBitwiseAnd(7, 12));
    }
}
