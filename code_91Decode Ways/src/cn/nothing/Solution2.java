package cn.nothing;

public class Solution2 {
    /*
     * 看懂大佬代码之后自己的尝试
     * */
    public static int numDecodings(String s) {
        char[] arr = s.toCharArray();
        if (arr[0] == '0') return 0;//特殊情况

        int pre = 1, cur = 1;//因为dp[i]=dp[i-1]+dp[i-2]
        for (int i = 1; i < s.length(); i++) {
            int temp = cur;//暂存dp[i-1]
            if (arr[i] == '0')
                if (arr[i - 1] == '1' || arr[i - 1] == '2') //出现10/20时
                    cur = pre;//dp[i]为dp[i-2]
                else return 0;//其他为不合法情况！
            else if (arr[i - 1] == '1' || (arr[i - 1] == '2' && arr[i] > '0' && arr[i] <= '6'))
                cur = pre + cur;//dp[i]=dp[i-1]+dp[i-2]
            //更新dp[i-2]为dp[i-1]
            pre = temp;
            System.out.println(cur + "+" + pre);
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(Solution2.numDecodings("22067"));
    }
}
