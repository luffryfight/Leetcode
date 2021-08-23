package cn.kobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * to do : 思路就正常回溯的思路，
 * 注意输入没给数组，需要自己创建
 * 如果它没给数组就不创建，还是挺难想的；
 *
 * @author 86137
 * @date 2021/4/22 22:38
 */
public class Review {
    List<List<String>> res = new ArrayList<>();
    char[][] nums;

    public List<List<String>> solveNQueens(int n) {
        nums = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nums[i], '.');
        }

        dfs(0, n);
        return res;
    }

    public void dfs(int i, int n) {
        if (i == n) {
            res.add(getList(n));
            //Arrays.fill(nums,'.');
            return;
        }
        for (int j = 0; j < n; j++) {
            if (valid(i, j)) {
                nums[i][j] = 'Q';
                dfs(i + 1, n);
                nums[i][j] = '.';
            }
        }
    }

    private boolean valid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (nums[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < nums.length; i--, j++) {
            if (nums[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (nums[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> getList(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new String(nums[i]));
        }
        return list;
    }
}
