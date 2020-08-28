package cn.kobe;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //happy
    List<String> res=new ArrayList<>();
    char[][] dic={{},{},{'a','b','c'},{'d','e','f'},
            {'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return res;
        StringBuilder sb=new StringBuilder();
        getBack(digits.toCharArray(),0,sb);
        return res;
    }
    private void getBack(char[] s,int k,StringBuilder sb){
        if(k==s.length){
            res.add(sb.toString());
            return;
        }
        if(sb.length()==s.length) res.add(sb.toString());
        char dit=s[k];
        for (int i = 0; i < dic[dit - '0'].length; i++) {
            sb.append(dic[dit - '0'][i]);
            getBack(s,k+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
