package cn.kobe;

public class Solution2 {
    public boolean isPalindrome(int x) {
        String str=new String(String.valueOf(x));
        char[] s=str.toCharArray();
        for (int i = 0; i < str.length()/2; i++) {
            if(s[i]!=s[s.length-1-i])
                return false;
        }
        return true;
    }
}
