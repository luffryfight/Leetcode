package cn.kobe;

/**
 * 作用：1ms 。。。思路还是简单，同样：注意细节的地方的处理
 * 2020/10/21
 */
public class Solution2 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        char[] str1 = name.toCharArray(), str2 = typed.toCharArray();
        while (i < name.length() && j < typed.length()) {
            int count1 = 0, count2 = 0;
            char ch1 = str1[i];
            while (i < name.length() && str1[i] == ch1) {
                count1++;
                i++;
            }
            char ch2 = str2[j];
            while (j < typed.length() && str2[j] == ch2) {
                count2++;
                j++;
            }
            if (count1 > count2 || ch1 != ch2)
                return false;
        }
        if (i == name.length() && j == typed.length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isLongPressedName("alex", "aaleex"));
    }
}
