package cn.sliding_window;

public class Leet239 {
    public int[] maxSlidingWindow(int[] nums, int k){
        int len=nums.length;
        if(len*k==0){
            return new int[0];
        }
        if(k==1){
            return nums;
        }
        int []res=new int[len-k+1];
        int index=-1,max=0;
        for (int i = 0; i < len-k+1; i++) {
            if(index>=i){
                if(nums[k+i-1]>max){
                    max=nums[k+i-1];
                    index=k+i-1;
                }
            }else{
                max=nums[i];
                for (int j = i+1; j < i + k; j++) {
                    if(nums[j]>max){
                        max=nums[i];
                        index=j;
                    }
                }
            }
            res[i]=max;
        }
        return res;
    }

}
