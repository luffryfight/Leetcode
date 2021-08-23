/**
 * 作用：计数排序，害，是我学艺不精
 * 因为题目说了元素取值范围 [0,100] 直接创建一个大小为100的数，统计时累加
 * 回想一下，如果注意到这个条件是否能想到这个方法
 * 可以，提示了一下就写出来了。100%时间
 * 2020/10/26
 */
public class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int ch : nums) {
            count[ch]++;
        }
        int add = 0;
        for (int i = 0; i <= 100; i++) {
            if (count[i] != 0) {//累计前面比当前数的小的
                int temp = count[i];
                count[i] = add;
                add += temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = count[nums[i]];
        }
        return nums;
    }

    public static void main(String[] args) {

        Boolean test = new Boolean(true);
        Boolean a1123a = true;
        System.out.println(a1123a == test);
        /*int[] nums={100,23,42,89,99};
        Solution2 solution=new Solution2();
        System.out.println(solution.smallerNumbersThanCurrent(nums));*/
    }
}
