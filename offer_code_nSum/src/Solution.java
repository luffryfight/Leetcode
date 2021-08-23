public class Solution {
    public static int sum(int n) {
//        System.out.println(n);
        boolean flag = n > 0 && (n += sum(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(Solution.sum(9));
    }
}
