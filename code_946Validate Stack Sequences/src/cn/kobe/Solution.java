package cn.kobe;

import java.util.Stack;

class Solution {
    //普通得栈对应就做出来了，
    //只不过题意可能有点难理解，就算弹出的元素要和popped数组对应
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }
}
