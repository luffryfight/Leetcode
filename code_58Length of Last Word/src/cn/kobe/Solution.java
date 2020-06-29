package cn.kobe;

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0) return 0;

        int count=0;
        char[] str=s.toCharArray();
        for (int i = str.length-1; i >= 0 ; i--) {
            if(str[i]==' '){
                if(count==0) continue;
                break;
            }
            count++;
        }
        return count;
    }
}
