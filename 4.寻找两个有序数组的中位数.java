/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (35.50%)
 * Likes:    1290
 * Dislikes: 0
 * Total Accepted:    71.3K
 * Total Submissions: 200.9K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int leftSize = l1 + ((l2 - l1 + 1) >> 1);
        if (l1 > l2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tempLen = l2;
            l2 = l1;
            l1 = tempLen;
        }
        int left, right;
        left = 0;
        right = l1;
        while (left < right) {
            int i = left + ((right - left + 1) >> 1);
            int j = leftSize - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        right = leftSize - left;
        int leftMax1 = left > 0 ? nums1[left - 1] : Integer.MIN_VALUE;
        int leftMax2 = right > 0 ? nums2[right - 1] : Integer.MIN_VALUE;
        int rightMin1 = left < l1 ? nums1[left] : Integer.MAX_VALUE;
        int rightMin2 = right < l2 ? nums2[right] : Integer.MAX_VALUE;
        if (((l2 + l1) & 1) == 1) {
            return Math.max(leftMax1, leftMax2);
        } else {
            int max = Math.max(leftMax1, leftMax2);
            int min = Math.min(rightMin1, rightMin2);
            return (double) (max + min) / 2;
        }
    }
}
// @lc code=end
