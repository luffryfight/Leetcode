package cn.kobe;

public class Solution {
    //模拟法，easy
    public boolean judgeCircle(String moves) {
        int row=0,cul=0;
        //转换为数组
        char[] str=moves.toCharArray();
        for(char ch:str){
            if(ch=='U'){
                cul++;
            }else if(ch=='D'){
                cul--;
            }else if(ch=='L'){
                row--;
            }else if(ch=='R'){
                row++;
            }
        }
        return row==0&&cul==0;
    }
}
