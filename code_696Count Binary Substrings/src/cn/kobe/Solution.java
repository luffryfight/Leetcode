package cn.kobe;

public class Solution {
    char[] str;
    public int countBinarySubstrings(String s) {
        if(s.length()<0)
            return 0;
        str=s.toCharArray();
        int count=0;
        int l=0,r=0;
        while (l<=r&&r<s.length()){
            if(r<s.length()-1)
                r++;
            else
                l++;
            int num=0;
            while(l<r&&((r-l+1)&1)==0&&(num=isSub(l,r))!=0){
                count+=num;
                int init=str[l];//L指向下一个不同字符
                while(l<r&&str[l+1]==init) l++;
                l++;
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

    public static void main(String[] args) {
        String s= "00100";//
        Solution2 so=new Solution2();
        System.out.println(so.countBinarySubstrings(s));
    }
}
