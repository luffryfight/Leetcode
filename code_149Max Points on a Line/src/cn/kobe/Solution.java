package cn.kobe;

import java.util.*;

/**
 * 作用：依次两两比较所有，得到结果，也就是枚举法
 * 但是在得到斜率的时候会有问题，会整除
 * 2021/1/17
 */
public class Solution {
    public int maxPoints(int[][] p) {
        Map<Double, Integer> map = new HashMap<>();
        Map<Integer, Integer> list = new HashMap<>();//斜率为无穷的，即分母为0；
        int max = 1;
        for (int i = 0; i < p.length; i++) {
            Set<Double> set = new HashSet<>();
            for (int j = i + 1; j < p.length; j++) {
                if (p[i][0] == p[j][0]) {
                    list.put(p[i][0], list.getOrDefault(p[i][0], 1) + 1);
                    continue;
                }
                double k = (p[j][1] - p[i][1] + 0.0) / (p[j][0] - p[i][0]);
                if (set.contains(k))//一个点只加一个斜率
                    continue;
                set.add(k);
                int num = map.getOrDefault(k, 1);
                map.put(k, num + 1);
                if (num + 1 > max)//更新结果
                    max = num + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(3.0 / 2);
        int[][] arr = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {2, 1}};
        Solution solution = new Solution();
        System.out.println(solution.maxPoints(arr));
    }
}
