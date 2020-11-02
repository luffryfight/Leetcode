package cn.kobe;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 作用：思路很简单啊，先遍历一遍，在遍历一次判断有无重复
 * 2020/10/28
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for (int ch : arr) {
            int num=map.getOrDefault(ch,0);
            map.put(ch,num+1);
        }
        for (Integer ch:map.keySet()){
            if (res.contains(map.get(ch))) return false;
            res.add(map.get(ch));
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr={1,2};
        Solution solution=new Solution();
        System.out.println(solution.uniqueOccurrences(arr));
    }
}
