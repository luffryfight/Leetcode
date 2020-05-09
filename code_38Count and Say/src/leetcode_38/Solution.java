package leetcode_38;

public class Solution {
    public static String countAndSay(int n) {
        String str="1";
        while(--n>0){
            str=convert(str);
        }
        return str;
    }
    public static String convert(String str){
        StringBuilder sb=new StringBuilder();
        int count=0;
        char pre=0;

        for(char temp:str.toCharArray()){
            if(pre!=temp){//出现了不同的字符，重新计数
                sb.append((char)(count+'0'));//根据规则先添加个数
                sb.append(pre);
                count=0;
            }
            ++count;
            pre=temp;
        }
        //添加最后一个字符
        sb.append((char)(count+'0'));
        sb.append(pre);
        sb.delete(0,2);//因为每次开始都会加入两个不必要的
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(Solution.countAndSay(5));
    }
}
