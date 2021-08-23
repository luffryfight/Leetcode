import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static int triangleNumber(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
//            if(i!=0&&nums[i-1]==nums[i])
//                continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
//                if(j!=i+1&&nums[j-1]==nums[j])
//                    continue;
                for (int k = j + 1; k < nums.length; k++) {
//                    if(j!=k-1&&nums[k-1]==nums[k])
//                        continue;
                    if (nums[i] + nums[j] > nums[k])
                        ++count;
                }
            }
        }
        return count;
    }
}
