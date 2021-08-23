public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 类似归并中的合并
         * * nums1中大小足够，说明不用创建新的数组
         * 把mn当作指向位置的指针
         * */
        int len = m + n;//从后往前放元素，因为nums1有空位
        while (n > 0 && m > 0) {
            nums1[--len] = (nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n]);
        }
        /*while(n>0) {//nums1先放完
            nums1[--len]=nums2[--n];
        }*/
        System.arraycopy(nums2, 0, nums1, 0, n);
        /*while(m>0) {//nums1先放完
            nums1[--len]=nums1[--m];
        }*///就算m>0，在nums1中也是有序的
    }
}
