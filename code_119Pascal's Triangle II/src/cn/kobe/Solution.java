package cn.kobe;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //先写一下递推的空间优化
    //这样的滚动数组感觉有点像dp的保存前状态了！
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        //base case
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);//为了让第I位上有空间
            for (int j = i; j > 0; j--) {//倒着赋值方便一些
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    //找规律 Cnm=Cn m-1 * ((n-m+1)/m)

    /**
     * @param * @param rowIndex
     * @return {@link List< Integer> }
     * @throws
     * @author 86137
     * @date 2021/2/12 15:35
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        //base case
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add((int) ((long) (row.get(i - 1) * (rowIndex - i + 1) / i)));
        }
        return row;
    }
}
