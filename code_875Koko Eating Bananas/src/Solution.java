import java.lang.reflect.Array;

public class Solution {
    public static int minEatingSpeed(int[] piles, int H) {

        int left = 1;
        int right = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (right < piles[i])
                right = piles[i];
        }
        while (left < right) {
            //int mid=left+(right-left)>>1;
            int mid = (right + left) / 2;
            if (canEat(piles, mid, H)) {
                ++left;
            } else
                right = mid;
        }
        return left;
    }

    private static boolean canEat(int[] arr, int speed, int H) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] + speed - 1) / speed;
        }
        return sum > H;
    }
}
