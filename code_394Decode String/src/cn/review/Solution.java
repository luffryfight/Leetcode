package cn.review;

import java.net.Socket;

/*
* 垃圾版本
* */
public class Solution {
    public static String decodeString(String s) {
        String str=new String();
        int count=0;
        int index=1;
        for (int i = 0; i < s.length(); i++) {
            char temp=s.charAt(i);
            if(temp=='['){
                String str1=new String();
                for(i+=1;i<s.length();i++){
                    if(s.charAt(i)==']')break;
                    str1+=s.charAt(i);
                }
                for (int j = 0; j < count; j++) {
                    str+=str1;
                }
                count=1;
            } else if (temp >= '0' &&temp<= '9') {
                count=temp-'0';
            }else{
                for (int j = 0; j < count; j++) {
                    str+=temp;
                    count=1;
                }
            }
        }
        return str;
    }
    /*public String getcount(String s,int start) {

    }*/
    public static void main(String[] args) {
        String s="3[a2[c]]";
        System.out.println(Solution2.decodeString(s));
    }
}
