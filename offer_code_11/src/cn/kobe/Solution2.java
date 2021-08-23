package cn.kobe;

class Solution2 {
    //暴力
    public int minArray(int[] numbers) {
        int pre = numbers[0];
        for (int now : numbers) {
            if (now < pre) return now;
            pre = now;
        }
        return numbers[0];
    }
}
