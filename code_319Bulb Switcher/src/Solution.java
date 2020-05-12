public class Solution {
    public static int bulbSwitch1(int n) {

        int []nums=new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=1;
        }
        int i=0;
        for ( i= 1; i < n-1; i++) {//执行开关等操作
            for(int j=i;j<n;j+=i+1){
                if ((nums[j] == 1)) {
                    nums[j] = 0;
                } else {
                    nums[j] = 1;
                }
            }
        }
        nums[i]=nums[i]==1?0:1;
        int count=0;//统计个数
        for (int s = 0; s< nums.length; s++) {
            if( nums[s]==1){
                ++count;
            }
        }
        return count;
    }
    public static int bulbSwitch(int n) {//最后发现规律
        return (int)Math.sqrt(n);
    }
    public static void main(String[] args) {
        System.out.println(Solution.bulbSwitch(1));
    }
}
