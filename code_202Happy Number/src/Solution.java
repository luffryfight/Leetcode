import java.util.HashSet;

public class Solution {
    public static boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        set.add(0);
        while(!set.contains(n)){
            set.add(n);
            int carry=Number(n);
            int sum=0;
            for (int i = 0; i < carry&&n>0; i++) {
                sum=sum+(n%10)*(n%10);
                n/=10;
            }
            if(sum==1){
                return true;
            }
            n=sum;
        }
        return false;
    }
    public static int Number(int n){
        int i;
        for(i=1;n>0;i++){
            n/=10;
        }
        return i;
    }
}
