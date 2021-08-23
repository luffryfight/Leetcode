package cn.kobe;

import java.util.ArrayList;
import java.util.List;

/**
 * to do :参考的最优解法
 *
 * @author 86137
 * @date 2021/4/22 22:48
 */
public class Solution3 {
    char[][] chars;
    boolean[] leftTop;
    boolean[] rightTop;
    boolean[] cols;
    int n;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return null;
        List<List<String>> rs = new ArrayList<>();
        this.n = n;
        leftTop = new boolean[2 * n - 1];
        rightTop = new boolean[2 * n - 1];
        cols = new boolean[n];
        chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }

        dfs(0, rs);

        return rs;
    }

    private void dfs(int row, List<List<String>> rs) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(chars[i]));
            }
            rs.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols[i]) continue;
            int leftTopI = row + i;
            if (leftTop[leftTopI]) continue;
            int rightTopI = row - i + n - 1;
            if (rightTop[rightTopI]) continue;

            chars[row][i] = 'Q';
            cols[i] = true;
            leftTop[leftTopI] = true;
            rightTop[rightTopI] = true;

            dfs(row + 1, rs);
            chars[row][i] = '.';
            cols[i] = false;
            leftTop[leftTopI] = false;
            rightTop[rightTopI] = false;
        }
    }
}
