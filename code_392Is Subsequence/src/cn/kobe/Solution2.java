package cn.kobe;

public class Solution2 {
    //滑动窗口不行，
    //可以逐个比对
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (char ch : s.toCharArray()) {
            index = t.indexOf(ch, index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }
}
