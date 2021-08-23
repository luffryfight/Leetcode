package cn.kobe;

/**
 * to do :
 *
 * @author 86137
 * @date 2021/2/27 21:27
 */
public class Solution {
    //注意收缩条件：题目中没说明就要自己创造条件！！
    //本题的收缩条件：当区间的不同字符个数大于某个值就收缩，也就是总保持区间内只有一定数量的字符
    //收缩之后再判断是否满足每个字符都大于K个。不确定就是满足条件的字符最多有多少个，所以遍历
    public int longestSubstring(String s, int k) {
        int len = s.length();
        char[] str = s.toCharArray();
        int res = 0;
        for (int i = getMaxNum(str); i >= 1; i--) {
            //System.out.println(getMaxNum(str));
            int[] count = new int[26];
            int valid = 0, words = 0;//分别表示区间无效字符的个数，字符的个数
            int left = 0, right = 0;
            while (right < len) {
                char ch = str[right];
                count[ch - 'a']++;
                if (count[ch - 'a'] == 1) {
                    words++;
                    valid++;
                }
                if (count[ch - 'a'] == k) {
                    valid--;
                }
                while (words > i) {
                    count[str[left] - 'a']--;
                    if (count[str[left] - 'a'] == k - 1) {
                        valid++;
                    }
                    if (count[str[left] - 'a'] == 0) {
                        words--;
                        valid--;
                    }
                    left++;
                }
                if (valid == 0) {
                    res = Math.max(res, right - left + 1);
                }
                right++;
            }
        }
        return res;
    }

    public int getMaxNum(char[] str) {
        int mask = 0;
        for (char ch : str) {
            mask |= 1 << (ch - 'a');
        }
        return Integer.bitCount(mask);
    }
}
