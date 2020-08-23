package cn.kobe;


import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    //这道题真的是练习深度的一道好题
    private static int TARGET=24;
    private static double EPSION=1e-6;
    private static int ADD=0,MULTIPY=1,SUBTRACT=2,DIVIDE=3;
    public boolean judgePoint24(int[] nums){
        List<Double> list=new ArrayList<>();
        for(int ch:nums)
            list.add((double)ch);
        return dfs(list);
    }
    private boolean dfs(List<Double> list){
        if(list.size()==0)
            return false;
        else if(list.size()==1)
            return Math.abs(list.get(0)- TARGET)<EPSION;//考虑误差
        int size=list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i!=j){
                    List<Double> list2=new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        if(k!=i&&k!=j)
                        list2.add(list.get(k));
                    }
                    for (int k = 0; k < 4; k++) {
                        if(k<2&&i>j)//优化
                            continue;
                        //深度遍历4中运算
                        if(k==ADD){
                            list2.add(list.get(i)+list.get(j));
                        }else if(k==MULTIPY){
                            list2.add(list.get(i)*list.get(j));
                        }else if(k==SUBTRACT){
                            list2.add(list.get(i)-list.get(j));
                        }else if(k==DIVIDE){
                            if(list.get(j)<EPSION)//判断被除数
                                continue;
                            else{
                                list2.add(list.get(i)/list.get(j));
                            }
                        }
                        if(dfs(list2))
                            return true;
                        //回溯
                        list2.remove(list2.size()-1);
                    }
                }
            }
        }
        return false;
    }
}
