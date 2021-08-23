package cn.lubao;

public class Solution {
    /*从开始到通过，15m左右，还算可以*/
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                break;
            else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        res[0] = left + 1;
        res[1] = right + 1;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Solution.twoSum(arr, 9));
    }
}
