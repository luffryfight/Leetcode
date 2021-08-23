class Solution3 {
    /*
     * 虽然是修改了细节，但是速度提高了很多，
     * 在不断改进的过程中，感觉很爽！！！
     */
    public static int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = 1000000000;//r最少100000；速度提高一倍
        while (l < r) {
            int m = (l + r) >> 1;
            if (check(piles, m, H))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    private static boolean check(int[] piles, int k, int H) {
        int hours = 0; //需要的小时
        for (int e : piles)
            hours += (e + k - 1) / k;
        return hours <= H;
    }
}
