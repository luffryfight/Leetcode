package cn;

public class Solution2 {

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        // ·窗口固定大小，尺寸参照s1.length()
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        int size = s1.length();

        char[] s1Ch = s1.toCharArray();
        char[] s2Ch = s2.toCharArray();
        // ·s1 s2同时初始化
        for (int i = 0; i < size; i++) {
            s1Arr[(int) (s1Ch[i] - 'a')]++;
            s2Arr[(int) (s2Ch[i] - 'a')]++;
        }

        for (int i = s1.length(), start = 0; i < s2.length(); i++, start++) {
            if (match(s1Arr, s2Arr)) {
                return true;
            }
            // ·窗口右移
            s2Arr[(int) (s2Ch[i] - 'a')]++;
            s2Arr[(int) (s2Ch[start] - 'a')]--;
        }

        return match(s1Arr, s2Arr);
    }

    private static boolean match(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
