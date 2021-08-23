class Solution {
    public int[] findErrorNums(int[] nums) {
        int len=nums.length;
        int yihuo=0;//异或剩余的就是重复的数
        for(int i=1;i<=len;i++){
            yihuo^=i;
        }
        for(int i=0;i<len;i++){
            yihuo^=nums[i];
        }
        int other=yihuo&(-yihuo);
        int num1=0,num2=0;
        for(int i=0;i<len;i++){
            if((nums[i]&other)==0){
                num1^=nums[i];
                //System.out.println(nums[i]);
            }else
                num2^=nums[i];
        }
        //System.out.println(num2+" "+num1); 比如2&6就等于2 不一定是0和1
        for(int i=1;i<=len;i++){
            if((i&other)==0){
                num1^=i;
            }else{
                num2^=i;
            }
        }
        //System.out.println(num2+" "+num1);
        for(int ch:nums){
            if(ch==num1){
                return new int[]{num1,num2};
            }
        }
        return new int[]{num2,num1};
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(2&6);
        System.out.println(solution.findErrorNums(new int[]{3, 2, 3, 4, 6, 5}));

    }
}