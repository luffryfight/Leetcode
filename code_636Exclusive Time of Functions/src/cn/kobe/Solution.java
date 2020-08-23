package cn.kobe;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res=new int[n];
        //创建栈,存入id;时间计算是两个函数的间隔 加 时刻
        Deque<Integer> stack=new ArrayDeque<>();

        String[] s=logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));

        int i=1;
        int prev=Integer.parseInt(s[3]);
        while (i<logs.size()){
            s=logs.get(i).split(":");
            if(s[1].equals("start")){
                if(!stack.isEmpty())
                    res[stack.peekLast()]+=Integer.parseInt(s[2])-prev;
                stack.push(Integer.parseInt(s[0]));
                prev=Integer.parseInt(s[2]);
            }else{
                //计算该函数消耗的时间
                res[stack.peek()]+=Integer.parseInt(s[2])- prev + 1;
                stack.pop();
                //上一个区间+times
                prev=Integer.parseInt(s[2])+1;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
    }
}
