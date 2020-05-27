package cn.none;

public class Solution {
    public static void moveZeroes(int[] nums) {
        if(nums.length<=1) return;
        int j=0;
        //向后移动
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){//一开始想的是交换，其实也不差啊
                nums[j++]=nums[i];
                //nums[i]=0;//这里不能赋0，因为当元素只有两个或者一个的时候会有问题
            }
        }
        //移动后，剩下位置赋0
        for (int i = j; i < nums.length; i++) {
            if(i>=0){
                nums[i]=0;
            }
        }
        int a=0;
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,3,12,123,0,2,4,64,0,65,7};
        Solution.moveZeroes(nums);
        System.out.println();
    }
}
