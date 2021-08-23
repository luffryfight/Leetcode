package cn.kobe;

public class Solution2 {
    /*
     * 动态规划啊，要想怎么利用前面的结果来算出后面的。
     * 用[0,3]作为蓝本来得到[4,7],以此类推
     * 递归关系 OPJ(X+b)=OPJ(X)+1,b=2^m(m=1,2,3,4....)>x
     * */
    int a;

    public int[] countBits(int num) {
        System.out.println(a);
        int[] res = new int[num + 1];
        int i = 0, b = 1;
        while (b <= num) {
            while (i < b && i + b <= num) {//不取2得幂次，因为i=0之后会赋值幂次de位置
                res[b + i] = res[i] + 1;
                i++;
            }
            i = 0;//i是相对值+b得索引
            b <<= 1;//扩大两倍
        }
        return res;
    }
}
