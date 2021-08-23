package cn.kobe;

/**
 * to do :回溯，复习
 *
 * @author 86137
 * @date 2021/2/19 18:29
 */
public class Review {
    //整体思路还是回溯遍历，在回溯的时候判断是否满足
    boolean[][] rows = new boolean[9][9], culs = new boolean[9][9], boxes = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int index = ch - '1';
                rows[i][index] = culs[j][index] = boxes[(i / 3) * 3 + j / 3][index] = true;
            }
        }
        dfs(board, 0);
    }

    public boolean dfs(char[][] board, int n) {
        if (n == 81) return true;
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') return dfs(board, n + 1);

        int i_box = (i / 3) * 3 + j / 3;
        for (int ch = 0; ch < 9; ch++) {
            if (rows[i][ch] || culs[j][ch] || boxes[i_box][ch]) continue;
            board[i][j] = (char) (ch + '1');
            rows[i][ch] = culs[j][ch] = boxes[i_box][ch] = true;
            if (dfs(board, n + 1)) return true;
            rows[i][ch] = culs[j][ch] = boxes[i_box][ch] = false;
        }
        //撤销对这个位置更改
        board[i][j] = '.';
        return false;
    }
}
