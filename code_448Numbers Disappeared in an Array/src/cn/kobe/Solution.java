package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/2/14 21:04
 */
public class Solution {
    //这道题的主要就是原地算法，说那么多。。。干嘛。
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] exists = new boolean[nums.length];

        for (int n : nums) {
            exists[n - 1] = true;
        }

        List<Integer> missings = new ArrayList<>(nums.length);
        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) {
                missings.add(i + 1);
            }
        }

        return missings;
    }
}
