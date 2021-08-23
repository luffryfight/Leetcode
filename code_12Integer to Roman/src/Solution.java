public class Solution {
    public static String intToRoman(int num) {
        String[][] str = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        String s = str[3][num / 1000];
        s += str[2][num / 100 % 10];
        s += str[1][num / 10 % 10];
        s += str[0][num % 10];

        return s;
    }
}
