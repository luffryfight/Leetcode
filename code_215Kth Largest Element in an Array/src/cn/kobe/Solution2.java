package cn.kobe;

import java.util.Arrays;

public class Solution2 {
    /*
     * 刷题的目的不是使用API，那就自己手写快排
     * */
    public static void qsort(int[] nums, int n, int k) {
        _qsort(nums, k, 0, nums.length - 1);
    }

    private static int median(int[] nums, int l, int r) {
        int c = (l + r) >> 1;
        if (nums[r] < nums[c]) {
            swap(nums, r, c);
        }
        if (nums[r] < nums[l]) {
            swap(nums, r, l);
        }
        if (nums[c] < nums[l]) {
            swap(nums, c, l);
        }
        //转移pivot，同时起边界的作用！
        swap(nums, c, r - 1);
        return nums[r - 1];
    }

    private static void _qsort(int[] nums, int k, int l, int r) {
        if (l + 3 <= r) {
            int pivot = median(nums, l, r);
            int i = l, j = r - 1;
            while (true) {
                while (nums[++i] < pivot) ;
                while (nums[--j] > pivot) ;
                if (i < j) {//i在左边
                    swap(nums, i, j);
                } else break;
            }
            //把转移的pivot交换回来，进行下一轮,i为边界
            swap(nums, i, r - 1);
            if (k <= i)
                _qsort(nums, k, 0, i - 1);//左半部分
            else
                _qsort(nums, k, i + 1, r);//右半部分
        } else {
            insert(nums, l, r);
        }
    }

    public static void insert(int[] nums, int i, int j) {
        for (int m = i + 1; m <= j; m++) {
            int temp = nums[m];
            int n;
            for (n = m; n > 0 && nums[n - 1] > temp; n--)
                nums[n] = nums[n - 1];
            nums[n] = temp;
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        qsort(nums, len, k);
        return nums[len - k];
    }

    //也可以显示交换，来提高速度
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(Solution2.findKthLargest(nums, 6));
    }

}
