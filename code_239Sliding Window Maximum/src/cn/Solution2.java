package cn;

public class Solution2 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k == 0) return new int[0];
        int[] res = new int[len - k + 1];//因为索引要+1
        for (int i = 0; i < len - k; i++) {//遍历数组
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i + k; j++) {//比较后面K个
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}
/*终极优化版本：
* class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
         if (nums == null || k < 1 || len < k) {//特殊情况
            return new int[0];
        }
        if(k==1){
            return nums;
        }
        //结果
        int[] res = new int[len-k+1];
        int maxIndex = -1, max = Integer.MIN_VALUE;
        for(int i = 0;i<len-k+1;i++){
            if(maxIndex>=i){
                if(max <= nums[i+k-1]){//和窗口的最后一个比较
                    max = nums[i+k-1];//和最后一个比较的原因在于，下面的else中已经判断了中间元素的大小
                    maxIndex = i+k-1;
                }
            }else{
                max = nums[i];
                for(int j = i;j<i+k;j++){
                    if(max<nums[j]){
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }
}
}*/
