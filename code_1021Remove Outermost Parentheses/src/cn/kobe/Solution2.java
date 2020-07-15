package cn.kobe;

public class Solution2 {
    /*
    * 参考别人的代码，厉害，意思就是用level双指针，指向有效最大括号的范围，其中的符号就添加
    * */
    class Solution {
        public String removeOuterParentheses(String S) {
            StringBuilder sb = new StringBuilder();
            int level = 0;
            for (char c : S.toCharArray()) {
                if (c == ')') --level;
                if (level >= 1) sb.append(c);
                if (c == '(') ++level;
            }
            return sb.toString();
        }
    }
}
