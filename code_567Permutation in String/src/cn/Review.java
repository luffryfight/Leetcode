package cn;

/**
 * 作用：
 * 2021/2/10
 */
public class Review {
    public static boolean checkInclusion(String s1, String s2) {
        char[] str1 = s1.toCharArray(), str2 = s2.toCharArray();
        int len1 = s1.length(), len2 = s2.length();

        //保存数量
        int[] arr1 = new int[26], arr2 = new int[26];
        int vaild = 0;//相同元素个数
        for (int i = 0; i < len1; i++) {
            arr1[str1[i] - 'a']++;
        }
        int left = 0, right = 0;
        while (right < len2) {
            char ch = str2[right];
            if (arr1[ch - 'a'] != 0) {
                arr2[ch - 'a']++;
                vaild++;
                if (vaild == len1 && isCan(arr1, arr2)) return true;
            }
            if (right - left + 1 >= len1) {
                if (arr2[str2[left] - 'a'] > 0) {
                    arr2[str2[left] - 'a']--;
                    vaild--;
                }
                left++;
            }
            right++;
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
        System.out.println(Review.checkInclusion("abc", "bbbca"));
    }
}
