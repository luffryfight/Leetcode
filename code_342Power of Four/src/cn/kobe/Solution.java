package cn.kobe;

public class Solution {
    /*
     * 类似于2的n次幂，找一个32的次方
     * */
    public boolean isPowerOfFour(int num) {
        //大于0，是2的次幂，二进制奇数位上是1的数
        return (num > 0) && ((num & (num - 1)) == 0) && (num & 0xaaaaaaaa) == 0;
    }
    /*public boolean isPowerOfFour(int num) {
        //数学归纳
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }*/

    /*public boolean isPowerOfFour(int num) {
        //判断nums是不是2的偶数次幂
        return (num > 0) && (Math.log(num) / Math.log(2) % 2 == 0);
    }*/

}
