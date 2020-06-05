package cn.kobe;

public class Solution {
    public int[] countBits(int num) {
        int[] res=new int[num+1];
        for (int i = 1; i <= num; i++) {
            res[i]=res[i&(i-1)]+1;//去掉末尾的1
            // res[i] = res[i >> 1] + (i & 1);也可以
        }
        return res;
    }
    /*
    * 学会利用已经学过的技巧
    * */
}
