package cn.kobe;

/**
 * 作用：本来还想用dp的方法，结果数学还是永远的神
 * 2020/12/9
 */
public class Solution {
    /*public int uniquePaths(int m, int n) {
        int x=m+n-2,y=m-1;
        long num1=1,num2=1;
        for (int i = x; i > x-y; i--) {
            num1*=i;
        }
        for (int i = 1; i <= y; i++) {
            num2*=i;
        }
        return (int)(num1/num2);
    }*/
    //改进
    public int uniquePaths1(int m, int n) {
        long num = 1;
        for (int i = m, j = 1; j < n; i++, j++) {
            num *= i / j;
        }

        return (int) num;
    }

    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(10, 10));
    }
}
