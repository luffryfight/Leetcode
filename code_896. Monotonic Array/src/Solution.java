/**
 * to do :两次遍历
 *
 * @author 86137
 * @date 2021/2/28 15:15
 */
public class Solution {
    //简单方法，遍历两次
    public boolean isMonotonic(int[] A) {
        boolean flag1 = true, flag2 = true;//只要满足递增或者递减就可以
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                flag1 = false;
            }
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                flag2 = false;
            }
        }
        return flag1 | flag2;
    }
}
