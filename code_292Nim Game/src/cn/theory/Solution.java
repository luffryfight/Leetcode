package cn.theory;

public class Solution {
    public boolean canWinNim(int n) {
        //寻找规律，当我们面对n是4的倍数时就一定会输，反正就会赢
        return n % 4 != 0;//不是4的倍数就赢
    }
}
