package cn.kobe;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * 作用：先用回溯遍历得到所有结果
 * 2020/12/8
 */
public class Solution {
    List<Integer> res = new LinkedList<>();

    public List<Integer> splitIntoFibonacci(String S) {

        dfs(S.toCharArray(), 0, 0, 0, res);
        return res;
    }

    public boolean dfs(char[] str, int index, int pre, int sum, List<Integer> list) {
        if (index == str.length) {
            return list.size() > 2;
        }
        long num = 0;
        for (int i = index; i < str.length; i++) {
            //一下几个判断基本都是剪枝
            if (i > index && str[index] == '0') {//不能以零开头，除了0本身
                break;
            }
            num = num * 10 + str[i] - '0';

            if (num > Integer.MAX_VALUE) {//超过整数范围
                break;
            }
            int temp = (int) num;
            if (list.size() > 1) {//有两个可以比较的,防止第一个就开始比较
                if (temp < sum) {
                    continue;
                } else if (temp > sum)
                    break;
                //意思只有相等才往下走
            }
            list.add(temp);
            if (dfs(str, i + 1, temp, pre + temp, list)) {
                return true;
            } else {
                list.remove(list.size() - 1);//删除最后一个
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.splitIntoFibonacci("0000"));
    }
}
