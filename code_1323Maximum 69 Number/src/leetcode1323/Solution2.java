package leetcode1323;

public class Solution2 {
    public static int maximum69Number (int num){
        //因为只需要换一位
        if(num/1000==6){
            num+=3000;
        }else if(num%1000/100==6){
            num+=300;
        }else  if(num%100/10==6){
            num+=3;
        }else if(num%10==6){
            num+=3;
        }
        return num;
    }
}
