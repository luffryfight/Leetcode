public class Solution {
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        char[] str=s.toCharArray();
        int left=0;
        int right=str.length-1;
        while(left<=right){
            if(!((str[left]>='0'&&str[left]<='9')||(str[left]>='a'&&str[left]<='z'))){
                ++left;continue;
            }
            if(!((str[right]>='0'&&str[right]<='9')||(str[right]>='a'&&str[right]<='z'))){
                --right;continue;
            }
            if(str[left]==str[right]){
                ++left;
                --right;
            }
            else return false;
        }

        return true;
    }
    public static boolean so2(String s){
        return isPalindrome(s);
    }
}
