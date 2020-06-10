package cn.kobe;

public class Solution {
    /*
    * 进阶?把数位拆开，累×
    * */
    public static boolean isPalindrome(int x) {
        if(x<=11&&x>=0&&x!=10)
            return true;
        else if(x<0||x%10==0)
            return false;
        int pre=0,sum=0;
        int temp=x;
        while(temp>0){//或者是每个数都相同的,这里要出去10的倍数
            pre=temp%10;
            sum=sum*10+pre;
            temp/=10;
        }
        return sum==x;
    }

    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome(101));
    }
}
