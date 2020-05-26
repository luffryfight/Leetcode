package cn.theory;

public class Solution {
    public static boolean isPowerOfThree(int n) {
        while(n>1){
            if(n==3){
                return true;
            }
            n/=3;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Solution.isPowerOfThree(19684));
    }
}
