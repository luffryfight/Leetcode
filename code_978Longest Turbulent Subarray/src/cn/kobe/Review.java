package cn.kobe;

/**
 * 作用：
 * 2021/2/8
 */
public class Review {
    //逻辑法（官方：滑动窗口）
    public int maxTurbulenceSize(int[] arr) {
        int res = 1, len = arr.length;
        int left = 0, right = 0;
        while (right < len - 1) {
            if (left == right) {
                if (arr[left] == arr[right + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] < arr[right] && arr[right + 1] < arr[right]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right + 1] > arr[right]) {
                    right++;
                } else {
                    left = right;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
