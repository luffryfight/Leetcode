package cn;

public class Solution3 {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        //转换为字符串，增加读取效率
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        //初始化字符串
        int valid = 0;
        for (int i = 0; i < str1.length; i++) {
            s1Arr[str1[i] - 'a']++;
            if (s1.indexOf(str2[i]) != -1) {
                s2Arr[str2[i] - 'a']++;
                valid++;
            }
        }
        //定义指针
        int left = 0, right = str1.length;

        while (right < s2.length()) {
            char left_ch = str2[left];
            char right_ch = str2[right];
            if (valid == str1.length) {
                if (isCan(s1Arr, s2Arr))
                    return true;
            }
            if (s1.indexOf(right_ch) != -1) {//存在
                s2Arr[right_ch - 'a']++;
                valid++;
            }
            if (s1.indexOf(left_ch) != -1 && s2Arr[left_ch - 'a'] != 0) {
                s2Arr[left_ch - 'a']--;
                valid--;
            }
            left++;
            right++;
        }
        if (valid == str1.length) {//最后一组得判断
            if (isCan(s1Arr, s2Arr))
                return true;
        }
        return false;
    }

    public static boolean isCan(int[] s1, int s2[]) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "adc";

        String s2 = "dcda";
        System.out.println(Solution3.checkInclusion(s1, s2));
    }
}
