package cn.theory;

public class Solution {
    public int trailingZeroes(int n) {
        //题目要求logn,所以使用递归
        //0的个数就是2*5的对数，但是像25是两个5，所直接递归
        return n==0?0:n/5+trailingZeroes(n/5);
    }
}
