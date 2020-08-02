package cn.kobe;

import java.util.Stack;

public class Solution2 {
    public int calculate(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        int res = 0;
        int num = 0;
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> resStack = new Stack<>();
        char op = '+';
        for (int i = 0; i < n; i++) {
            if (array[i] == ' ') {
                continue;
            }
            if (array[i] >= '0' && array[i] <= '9') {
                num = num * 10 + array[i] - '0';
            } else if (array[i] == '+' || array[i] == '-') {
                if (op == '+') {
                    res = res + num;
                }
                if (op == '-') {
                    res = res - num;
                }
                num = 0;
                op = array[i];
                //遇到左括号，将结果和括号前的运算保存，然后将参数重置
            } else if (array[i] == '(') {
                resStack.push(res);
                opStack.push(op);

                //将参数重置
                op = '+';
                res = 0;
            } else if (array[i] == ')') {
                //将右括号前的当前运算结束
                //比如 (3 + 4 - 5), 当遇到右括号的时候, - 5 还没有运算
                //(因为我们只有遇到操作符才会进行计算)
                if (op == '+') {
                    res = res + num;
                }
                if (op == '-') {
                    res = res - num;
                }

                //将之前的结果和操作取出来和当前结果进行运算
                char opBefore = opStack.pop();
                int resBefore = resStack.pop();
                if (opBefore == '+') {
                    res = resBefore + res;
                }
                if (opBefore == '-') {
                    res = resBefore - res;
                }

                //将参数重置
                op = '+';
                num = 0;
            }
        }
        if (op == '+') {
            res = res + num;
        }
        if (op == '-') {
            res = res - num;
        }
        return res;
    }
}
