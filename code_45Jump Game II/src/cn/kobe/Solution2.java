package cn.kobe;

public class Solution2 {
    //也可以直接dp
    //或者回溯，得到最优的，框架简单，但是实现复杂一点 ，这个算法 0ms
    //感觉也就是从后往前贪心
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }

            if (nums.length == 1) {
                return true;
            }
            // 从最后开始往前回溯
            return backtrack(nums, nums.length - 1);
        }

        private boolean backtrack(int[] nums, int end) {
            // 从最后开始往前回溯
            for (int i = end - 1; i >= 0; i--) {
                if (nums[i] == 0) {
                    // 如果回溯到某一个节点值为0
                    if (i == 0) {
                        // 该节点下标为0，也就是说首节点就是0，肯定就哪儿也去不了啊，false
                        return false;
                    }
                    // 否则就说明不能跳该节点，应该绕开该为0的节点
                    for (int j = i - 1; j >= 0; j--) {
                        // 这个判断就是找从j节点能直接跳过为0的i节点的遍历
                        if (nums[j] > (i - j)) {
                            // 找到就从那个节点回溯
                            return backtrack(nums, j);
                        }
                    }
                    // 找不到能绕过0节点的，就失败了
                    return false;
                }
            }
            // 到这里，说明可以通过
            return true;
        }
    }
}
