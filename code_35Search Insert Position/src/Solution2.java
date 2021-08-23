import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

public class Solution2 {
    /*
     * 二分法做
     * 下面的处理会更好一点
     * */
    public int searchInsert(int[] nums, int target) {
        //头部和尾部
        /*if(nums[0]>target) return 0;
        else if(nums[nums.length-1]<target) return nums.length;
        //长度为1就不用二分了，直接比较
        if(nums.length==1){
            if(nums[0]>=target)return 0;
            else return 1;
        }*/
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //出现在数组中间的情况
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                return mid;
            }
        }
        //此时left==right
        return nums[l] > target ? l : l + 1;
    }
}
/*
* public int searchInsert(int[] nums, int target) {
        //简单的二分查找
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //小知识点： java数组的最大长度为int的最大值
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //此时left = right
        return target <= nums[left] ? left : left + 1;
    }
    * */