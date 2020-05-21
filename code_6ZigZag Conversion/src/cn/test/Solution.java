package cn.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static String convert(String s, int numRows) {
        if(numRows==1) return s;
        String[] str=new String[numRows];//保存每行

        int flag=-1;//因为从0开始，先*-1得到正
        int index=0;
        Arrays.fill(str,"");
        for (char ch:s.toCharArray()) {
            if(index==0||(index+1)%numRows==0) flag*=-1;
            str[index]+=ch;
            index+=flag;
        }

        for (int i = 1; i < numRows; i++) {
            str[0]+=str[i];
        }
        return str[0];
        /*StringBuilder sb=new StringBuilder();
        for(String temp:str){
            sb.append(temp);
        }
        return sb.toString();*/

    }

    public static void main(String[] args) {
        String s="LEETCODEISHIRING";
        System.out.println(Solution.convert(s,3));
    }
}
