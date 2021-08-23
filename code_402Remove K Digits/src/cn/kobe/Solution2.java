package cn.kobe;

/**
 * 作用：提示用栈，然后马上就想到了
 * 尝试用贪心做 双指针 果然效率是要低一些
 * 2020/11/15
 */
class Solution2 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {//特殊情况
            return "0";
        }
        StringBuilder str = new StringBuilder(num);
        while (k > 0) {
            int index = 0;//要删除的位
            char[] arr = str.toString().toCharArray();
            for (int i = 1; i < str.length(); i++) {
                if (arr[i] >= arr[i - 1]) {
                    index = i;
                } else break;//遇到递减的位就退出
            }
            str.deleteCharAt(index);
            --k;
        }
        //判断特殊情况和剩余处理
        while (str.length() > 1 && str.charAt(0) == '0')
            str.deleteCharAt(0);
        return str.length() < 1 ? "0" : str.toString();
    }
}