package cn.kobe;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 作用： 用单调栈的思想
 * 2020/10/21
 */
public class Solution {
    public int nextGreaterElement(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] str = (n + "").toCharArray();
        int s1 = -1, s2 = -1;
        boolean flag = false;
        for (int i = str.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && str[i] < str[stack.peekLast()]) {
                s2 = stack.pollLast();
                flag = true;
            }
            if (flag) {
                s1 = i;
                break;
            }
            stack.addLast(i);
        }
        if (flag == false)
            return -1;
        swap(str, s1, s2);
        reverse(str, s1 + 1);
        try {
            return Integer.parseInt(new String(str));
        } catch (Exception e) {
            return -1;
        }
    }

    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreaterElement(1999999999));
    }
}
