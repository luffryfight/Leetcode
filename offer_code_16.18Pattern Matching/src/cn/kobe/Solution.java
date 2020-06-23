package cn.kobe;

public class Solution {
    /*
    * 都是暴力搜索啊。。。
    * */
    public boolean patternMatching(String pattern, String value) {
        //特殊情况
        if(pattern.equals("a")||pattern.equals("b")){
            return true;
        }
        if(pattern.length()==0){
            return value.length()==0;
        }
        //转换为字符数组
        char[] pArr=pattern.toCharArray();
        char[] vArr=value.toCharArray();
        // value为空时，判断pattern是否只有a或只有b
        if (value.length() == 0) {
            boolean aExist = false,bExist = false;
            for (char c: pArr) {
                if (c == 'a') {
                    aExist = true;
                }
                else {
                    bExist = true;
                }
                if (aExist && bExist) {
                    return false;
                }
            }
            return true;
        }
        int counta=0,countb=0;
        for(char ch:pArr){
            if(ch=='a')
                counta++;
            else
                countb++;
        }
        int lenV=value.length();
        if (counta * countb == 0) {
            int count = counta + countb;
            if (lenV % count != 0) return false;

            int len = lenV / count;
            String temp=value.substring(0,len);
            for (int i = len; i < lenV; i += temp.length()) {
              if(!value.substring(i,i+temp.length()).equals(temp)) return false;
            }
            return true;
        }
        // //lv=ca*la+cb*lb 遍历这个方程
        int a=pArr[0];//用于遍历数组
        for(int la=0;la*counta<=value.length();la++){
            int rest=lenV-counta*la;
            if(rest%countb!=0 ) continue;
            int lb=rest/countb,dis=0;//取strb的长度
            boolean isMatch=true;
            String stra="";String strb="";
            for(char ch:pArr){
                if(ch==a){
                    String tempa=value.substring(dis,dis+=la);
                    if(stra.length()==0){
                        stra=tempa;
                    }else if(!stra.equals(tempa)) {
                        isMatch=false ; break;
                    }
                }else{
                    String tempb=value.substring(dis,dis+=lb);
                    if(strb.length()==0){
                        strb=tempb;
                    }else if(!strb.equals(tempb)) {
                        isMatch=false ; break;
                    }
                }
            }
            if(isMatch&&!stra.equals(strb)) return true;//提前结束
        }
        return false;
    }
}
