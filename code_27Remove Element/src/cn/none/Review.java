package cn.none;

/**
 * 作用：原地算法
 * 2021/2/1
 */
public class Review {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int flag = len;
        for (int i = 0; i < flag; ) {
            if (nums[i] == val) {
                nums[i] = nums[flag - 1];
                flag--;
            } else {
                i++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        Review review = new Review();
        System.out.println(review.removeElement(arr, 3));
    }
}
