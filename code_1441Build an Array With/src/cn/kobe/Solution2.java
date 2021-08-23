package cn.kobe;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    //但是好像没用到栈的思想
    public static List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < target.length; i++, j++) {//两个相同时j也需要同步增加
            while (target[i] > j) {
                res.add("Push");
                res.add("Pop");
                j++;
            }
            res.add("Push");
        }
        return res;
    }
}
