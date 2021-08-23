package cn.kobe;

/**
 * 作用：
 * 2021/1/24
 */
class Review {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //删减的思想
        int m = nums1.length, n = nums2.length;
        int left = (m + n + 1) / 2, right = (m + n + 2) / 2;//这样可以保证当总数的偶数时，right比left大1，奇数时left==right
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];//-1 之后才是索引
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;//防止越界
        int mid2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) {//其中一个数组个数很少时,就会取另一个数组的第k个,按照下面递归进去时一样的
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        }
        return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }
}