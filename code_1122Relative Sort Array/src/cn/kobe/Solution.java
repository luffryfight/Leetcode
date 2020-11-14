package cn.kobe;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 作用：
 * 2020/11/14
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> count=new HashMap<>();//字典
        for (int ch : arr1) {
            count.put(ch,count.getOrDefault(ch,0)+1);
        }
        int index=0,sort=0;
        for (int ch : arr2) {
            for (Integer i = 0; i < count.get(ch); i++) {
                arr1[index++]=ch;
            }
            sort=index;//保存后面要排序的起始索引
            count.remove(ch);
        }
        //剩下没出现的
        for (Integer ch : count.keySet()) {
            for (Integer i = 0; i < count.get(ch); i++) {
                arr1[index++]=ch;
            }
            //count.remove(ch);
        }
        Arrays.sort(arr1,sort, arr1.length);
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1={2,3,1,3,2,4,6,7,9,2,19,1,3,2,5,4,5,53,2,3,1};
        int[] arr2={2,1,4,3,9,6};
        Solution solution=new Solution();
        System.out.println(solution.relativeSortArray(arr1,arr2));
    }
}
