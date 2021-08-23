package cn.kobe;

class Solution2 {
    //用数组模拟栈
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        int[] stack = new int[len + 1];
        int istack = 0, ipushed = 0, ipop = 0;
        while (ipushed < len) {
            stack[istack++] = pushed[ipushed++];
            while (istack > 0 && stack[istack - 1] == popped[ipop]) {
                istack--;
                ipop++;
            }
        }
        return ipop == len;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 3, 5, 1, 2};
        System.out.println(Solution2.validateStackSequences(arr1, arr2));
    }
}
