package cn.kobe;

public class Solution2 {
    /*
    * 创建类似于qsort中的区分的标志
    * [l,r)表示1的范围
    * */
    public static void sortColors(int[] nums) {
        if(nums.length<=1) return;

        //建立标志
        int l=0,r=nums.length-1;
        for (int i = 0; i < nums.length&&i<=r;) {
            if(nums[i]==0) {
                swap(nums,l,i);
                l++;i++;
            }else if(nums[i]==2){//这种情况i不++
                swap(nums,r,i);
                r--;
                continue;
            }else if(nums[i]==1)
                i++;
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0,1,1,0,1,2,0};
        Solution2.sortColors(nums);
        for (int temp:nums) {
            System.out.print(temp+" ");
        }
    }
    /*
    * 运行结果同1
    * */
}
