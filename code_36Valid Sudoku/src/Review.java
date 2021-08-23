import java.util.HashMap;

/**
 * to do :复习
 *
 * @author 86137
 * @date 2021/2/16 21:34
 */
public class Review {
    //只有遍历，然后保存
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] culs = new HashMap[9];
        HashMap<Integer, Integer>[] boxs = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            culs[i] = new HashMap<Integer, Integer>();
            boxs[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = (int) (board[i][j] - '0');
                    int index_box = (i / 3) * 3 + j / 3;

                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    culs[j].put(num, culs[j].getOrDefault(num, 0) + 1);
                    boxs[index_box].put(num, boxs[index_box].getOrDefault(num, 0) + 1);

                    if (rows[i].get(num) > 1 || culs[j].get(num) > 1 || boxs[index_box].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
