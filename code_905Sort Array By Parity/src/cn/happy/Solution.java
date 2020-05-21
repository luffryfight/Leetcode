package cn.happy;

public class Solution {
    public static int[] sortArrayByParity(int[] A) {
        int j=0;
        for (int i = 0; i < A.length; i++) {
            if((A[i]&1)==0||A[i]==0){//偶数
                int temp=A[j];
                A[j]=A[i];
                A[i]=temp;
                j++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] s={0,1,2};
        System.out.println(Solution.sortArrayByParity(s));
    }
}
