package cn.kobe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 作用：练习使用定义规则
 * 2020/11/16
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1,o2)->
                o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]
        );//定义排序规则
        List<int[]> list=new LinkedList<>();
        for (int[] ch: people){
            list.add(ch[1],ch);
        }
        return list.toArray(people);
    }
}
