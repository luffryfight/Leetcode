package cn.kobe;

public class Solution3 {
    /*
    * 奇怪的技巧：
    * -----a-----b------c
    * 当nums[i]=0时:nums[c+1]=2,nums[b+1]=1,nums[a+1]=0;
    * 当nums[i]=1时:nums[c+1]=2,nums[b+1]=1;
    * 当nums[i]=2时:nums[c+1]=2;
    * */
    
    public void sortColors(int[] nums) {
        if(nums.length<=1) return;

        //建立标志
        int a=-1,b=-1,c=-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                nums[++c]=2;nums[++b]=1;nums[++a]=0;
            }else if(nums[i]==1){
                nums[++c]=2;nums[++b]=1;
            }else{
                nums[++c]=2;
            }
        }
    }
}
