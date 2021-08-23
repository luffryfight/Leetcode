/**
 * 作用：复习
 * 2021/1/28
 */
public class Review {
    class Solution {
        public int romanToInt(String s) {
            char[] str = s.toCharArray();
            int res = 0;
            for (int i = 0; i < str.length; i++) {
                char ch = str[i];
                int num = getValue(ch);
                res += num;
                if (ch == 'I') {
                    if (i < str.length - 1 && (str[i + 1] == 'V' || str[i + 1] == 'X')) {
                        res -= 2 * num;
                    }
                } else if (ch == 'X') {
                    if (i < str.length - 1 && (str[i + 1] == 'C' || str[i + 1] == 'L')) {
                        res -= 2 * num;
                    }
                } else if (ch == 'C') {
                    if (i < str.length - 1 && (str[i + 1] == 'D' || str[i + 1] == 'M')) {
                        res -= 2 * num;
                    }
                }
            }
            return res;
        }

        public int getValue(char ch) {
            switch (ch) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
        }
    }
}
