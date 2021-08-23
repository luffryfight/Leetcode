package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/2/14 19:50
 */
public class Solution {
    //怎么想的就怎么做！然后再慢慢优化啊
    //思路：先遍历获取该位置上的对象所在地方，然后交换
    //虽然这个直接通过了，而且还是100%....本以来很难啥的
    //那就多写几个解题方式
    public int minSwapsCouples(int[] row) {
        int res = 0;
        for (int i = 0; i < row.length - 1; i += 2) {
            int target = row[i] ^ 1;//这一步很重要
            if (row[i + 1] == target) {
                continue;
            }
            for (int j = i + 1; j < row.length; j++) {
                if (row[j] == target) {
                    target = j;
                    break;
                }
            }
            //交换
            int temp = row[target];
            row[target] = row[i + 1];
            row[i + 1] = temp;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
    }

}
