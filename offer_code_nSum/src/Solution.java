public class Solution {
    public static int sum(int n){
//        System.out.println(n);
       boolean b =  n>0&&((n+=sum(n-1))>0);
       return n;
    }
}
