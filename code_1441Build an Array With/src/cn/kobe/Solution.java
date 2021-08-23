package cn.kobe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static List<String> buildArray(int[] target, int n) {
        Deque<String> stack = new ArrayDeque<>();
        int index = 0;
        //这里确实没有用到pop
        for (int i = 1; i <= n && index < target.length; i++) {
            stack.push("Push");
            if (target[index] != i)
                stack.push("Pop");
            else
                index++;
        }
        List<String> res = new ArrayList<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            res.add(stack.pollLast());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};

        System.out.println(Solution2.buildArray(arr, 3));
    }
}
