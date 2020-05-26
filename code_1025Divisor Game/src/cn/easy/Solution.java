package cn.easy;

public class Solution {
    public boolean divisorGame(int N) {
        //博弈论，最终是偶数的话就会赢
        return (N&1)==0;
    }
}
