package cn.kobe;

import com.sun.media.sound.RIFFInvalidDataException;

/**
 * 作用： 懂了之后的自己写
 * <p>
 * 2020/10/25
 */
public class Solution3 {
    public static void main(String[] args) {
        int m = 1, n = 0;
        n = (m--) + (++m);
        System.out.println(n);
        String s1 = "java";//先在常量池获取，没有创建之后再放入常量池
        String s2 = new String("java");//在堆中创建对象
        /*String s1="ja"+"va";
        String s2="java";
        System.out.println(s1==s2);//true*/
    }

    //2,1,4,7,3,2,5
    public int longestMountain(int[] A) {
        int left = 0, right = 0;
        int res = 0, len = A.length;
        while (left < len - 2) {//防止right溢出
            right = left + 1;
            if (A[left] < A[right]) {
                while (right < len - 1 && A[right] < A[right + 1]) {//找到山顶了
                    right++;
                }
                if (right < len - 1 && A[right] > A[right + 1]) {
                    while (right < len - 1 && A[right] > A[right + 1]) {//找到山顶了
                        right++;
                    }
                    res = Math.max(res, right - left + 1);
                } else {//结束
                    right++;
                }
            }
            left = right;
        }
        return res;

    }
}
