public class Solution2 {
    public static int minEatingSpeed(int[] piles, int H) {
        int left = 0;
        int right = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (right < piles[i]) {
                right = piles[i];
            }
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, mid, H)) {//速度慢了
                left = mid + 1;
            } else
                right = mid;
        }
        return left;
    }

    private static boolean canEat(int[] pilse, int speed, int H) {
        int sum = 0;
        for (int i = 0; i < pilse.length; i++) {
            sum += (pilse[i] + speed - 1) / speed;
        }
        return sum > H;
    }
}
