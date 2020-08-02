package cn.kobe;

public class Solution2 {
    //通过标志，依次删除多余的左右括号
    public String minRemoveToMakeValid(String s){
        int left=0,right=0;
        int balance=0;
        //保存字符串
        StringBuilder sb=new StringBuilder();
        //去除多余的右括号
        for(char ch:s.toCharArray()){
            if(ch=='('){
                left++;//统计左括号多少个
                balance++;
            }
            else if(ch==')') {
                if(balance==0) continue;
                balance--;
            }
            sb.append(ch);
        }
        right=left-balance;//总的‘（’ - 多余的 ==有效的
        //保存结果
        StringBuilder res=new StringBuilder();
        for(char ch:sb.toString().toCharArray()){
            if(ch=='('){
                right--;
                if(right==0) continue;
            }
            res.append(ch);
        }
        return res.toString();
    }

}
