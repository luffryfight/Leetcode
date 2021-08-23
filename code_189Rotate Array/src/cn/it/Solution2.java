package cn.it;

public class Solution2 {

    /*
     * 伤心。.。。自己的思路2，还差两步关键的代码。。然后看了题解
     * */
    /*
     * 原来的思路上加一层循环，，，
     * */
    public static void rotate(int[] nums, int k) {
        int temp = nums[0];//用于交换的暂时变量
        int index = 0;
        int len = nums.length;
        if (nums.length % k == 0) {
            len = nums.length / 2 + 1;
        }
        while (--len > 0) {
            int next = (index + k) % nums.length;//下一个坐标索引
            if (nums.length % k == 0) {//这种情况是，i++遍历一半，temp取下一个暂存
                nums[index] = nums[next];
                nums[next] = temp;
                index++;
                temp = nums[index];
            } else {////保存下一个地点的位置
                nums[0] = nums[next];
                nums[next] = temp;
                index = next;
                temp = nums[0];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Solution2.rotate(nums, 2);
        for (int ch : nums) {
            System.out.print(ch + " ");
        }
    }
}
