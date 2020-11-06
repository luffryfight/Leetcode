package cn.kobe;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.Arrays;

/**
 * 作用：题解区的大佬
 * 主要是当排序需要取决于两个因素时，可以按照这种方式来
 * 2020/11/6
 */
public class Solution2 {
    public int[] sortByBits(int[] arr){
        int level=100000;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=getCount(arr[i])*level+arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i]%=level;
        }
        return arr;
    }
    public int getCount(int num){
        int count=0;
        while(num>0){
            num&=num-1;
            count++;
        }
        return count;
    }
}
