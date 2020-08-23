package cn.kobe;

class Solution3 {
    //把官方题解优化下就是双百欸，
    //思路最重要啊啊
    public int countBinarySubstrings(String s) {
        char[] str=s.toCharArray();
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = str[ptr];
            int count = 0;
            while (ptr < n && str[ptr] == c) {
                ++ptr;
                ++count;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }
}
