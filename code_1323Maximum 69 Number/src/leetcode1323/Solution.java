package leetcode1323;

public class Solution {
    public static int maximum69Number (int num) {
        String str=num+"";//转化成字符串
        str=str.replaceFirst("6","9");
        return Integer.parseInt(str);
    }
    /*
    *for(int i=0;i<str.length();++i){
            if(str.indexOf(i)=='6'){
                str.indexOf(i,'9');
                break;
            }
        }
     */
}
