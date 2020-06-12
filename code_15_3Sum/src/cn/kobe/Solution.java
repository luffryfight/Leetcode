package cn.kobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
    * 双指针移动
    * */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            if(nums[i]>0) break;
            int left=i+1,right=nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> temp=new ArrayList<>(3);
                    temp.add(nums[i]);temp.add(nums[left]);temp.add(nums[right]);
                    res.add(temp);
                    while(left<right&&nums[left]==nums[left+1]) left++;//跳过重复元素
                    left++;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( Solution.threeSum(new int[]{0,0,0}));
    }
}
