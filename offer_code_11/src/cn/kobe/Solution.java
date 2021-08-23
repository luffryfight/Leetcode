package cn.kobe;

public class Solution {
    // 456123
    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 1, 1, 2};
        System.out.println(Solution.minArray(arr));
    }
}
