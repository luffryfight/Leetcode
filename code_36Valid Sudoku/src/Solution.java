public class Solution {
    public static boolean isValidSudoku(char[][] board) {
        //三个判断条件
        int[][] row = new int[9][10];
        int[][] cul = new int[9][10];
        int[][] box = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int number = board[i][j] - '0';
                if (row[i][number] == 1) {
                    return false;
                } else
                    row[i][number] = 1;

                if (cul[j][number] == 1) {
                    return false;
                } else
                    cul[j][number] = 1;

                if (box[(i / 3) * 3 + j / 3][number] == 1)
                    return false;
                else
                    box[(i / 3) * 3 + j / 3][number] = 1;

            }
        }
        return true;
    }
}
