public class Solution {
    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        int total=0;
        int num1=1;
        int num2=2;
        for (int left = 2; left < n; left++) {
            total=num1+num2;
            num1=num2;
            num2=total;
        }

        return total;
    }
}
