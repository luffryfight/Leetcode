package cn.kobe;

import java.util.Arrays;

public class Solution {
    public static int findBestValue(int[] arr, int target) {
        int len = arr.length;
        //取平均数
        int start = target / len;
        int index, sum = 0;
        Arrays.sort(arr);
        for (index = 0; index < len; index++) {
            if (arr[index] >= start)
                break;
            sum += arr[index];
        }
        int min = Integer.MAX_VALUE, res = 0;
        int temp = 0, flag = 1;
        while (index < len) {
            if (start >= arr[index] && flag == 1) {
                sum += arr[index];
                flag = 0;
                //index是否++
            }
            temp = sum + (index == 0 ? (len - index) * start : (len - index - 1) * start);
            int dist = Math.abs(temp - target);
            if (min > dist) {
                min = dist;
                res = start;
                if (min == 0) return res;
            } else break;
            start++;
            if (index < len - 1 && start >= arr[index + 1]) {
                index++;
                flag = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {60864, 25176, 27249, 21296, 20204};
        //int[] nums={2,3,5};
        System.out.println(Solution.findBestValue(nums, 56803));
    }
}
