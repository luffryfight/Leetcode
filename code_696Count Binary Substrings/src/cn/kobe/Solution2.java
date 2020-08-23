package cn.kobe;

public class Solution2 {
    //超出时间
    char[] str;
    public int countBinarySubstrings(String s) {
        if(s.length()<0)
            return 0;
        str=s.toCharArray();
        int len=s.length();
        int count=0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if((j-i+1)%2==0&&isSub(i,j)!=0)
                    count++;
            }
        }
        return count;
    }
    //获取一段字符串是不是符合题意
    private int isSub(int l,int r){
        int count=0;
        char init=str[l];
        while(l<r){
            if(str[l]!=init||str[r]==init)
                return 0;
            else count++;
            l++;r--;
        }
        return count;
    }
}
