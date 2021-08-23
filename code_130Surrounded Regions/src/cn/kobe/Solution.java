package cn.kobe;

import netscape.security.UserTarget;

public class Solution {
    //四个方向,很nice
    //自己做出来就很nice啊
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] visit;
    int m, n;

    public void solve(char[][] board) {
        if (board.length <= 1)
            return;
        m = board.length;
        n = board[0].length;
        visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && visit[i][j] == 0 && board[i][j] == 'O')
                    dfs(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 0)
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] str, int i, int j) {
        if (visit[i][j] == 1)
            return;
        visit[i][j] = 1;
        for (int[] ser : dir) {
            int x = i + ser[0];
            int y = j + ser[1];
            if (!isCan(x, y)) continue;
            if (str[x][y] == 'O')
                dfs(str, x, y);
        }
    }

    private boolean isCan(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
