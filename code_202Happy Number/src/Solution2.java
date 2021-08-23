class Solution2 {//

    public boolean isHappy(int n) {
        if (n == 0) return false;
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = sum;
            if (n == 4) return false;//数学规律判断
        }
        return true;
    }
}
