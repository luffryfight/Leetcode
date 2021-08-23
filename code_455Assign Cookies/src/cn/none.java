package cn;

import java.util.Arrays;

public class none {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;

        int leng = 0, lens = 0;
        //进行排序，双指针依次比较
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;//计数
        while (leng < g.length && lens < s.length) {
            if (g[leng] <= s[lens]) {//如果满足胃口
                count++;
                leng++;
            }
            //都需要++
            lens++;
        }
        return count;
    }
}
