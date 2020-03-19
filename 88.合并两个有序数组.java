/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 * 
 * started at 2020-03-19 23:42:33
 * 
 * finished at 2020-03-20 00:08:27
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (44.85%)
 * Likes:    447
 * Dislikes: 0
 * Total Accepted:    123.6K
 * Total Submissions: 262.6K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pre, post;
        pre = m - 1;
        post = m + n - 1;
        int i;
        for (i = n - 1; i >= 0 && pre >= 0;) {
            if (nums2[i] > nums1[pre]) {
                nums1[post] = nums2[i];
                post--;
                i--;
            } else {
                nums1[post] = nums1[pre];
                post--;
                pre--;
            }
        }
        while (i >= 0) {
            nums1[post--] = nums2[i--];
        }
    }
}
// @lc code=end
