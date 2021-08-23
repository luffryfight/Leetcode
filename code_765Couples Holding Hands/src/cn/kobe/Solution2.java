package cn.kobe;

/**
 * to do :空间换时间 哈希表保存索引
 * 并且，交换也只需要交换表里的索引
 * 还要一个重要的点：异或 奇数->n-1 偶数->n+1
 *
 * @author 86137
 * @date 2021/2/14 19:58
 */
public class Solution2 {
    public int minSwapsCouples(int[] row) {
        int res = 0;
        int[] map = new int[row.length];//保存索引
        for (int i = 0; i < row.length; i++) {
            map[row[i]] = i;
        }
        for (int i = 0; i < row.length - 1; i += 2) {
            int target = row[i] ^ 1;//这一步很重要
            if (row[i + 1] == target) {
                continue;
            }
            int index = map[target];//获取索引，key为目标值
            //交换
            int temp = row[index];
            row[index] = row[i + 1];
            row[i + 1] = temp;
            //修改map
            map[row[index]] = index;
            res++;
        }
        return res;
    }

}
