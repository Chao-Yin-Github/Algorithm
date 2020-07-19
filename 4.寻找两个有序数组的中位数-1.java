import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            nums1 = new int[0];
        }
        if (nums2 == null) {
            nums2 = new int[0];
        }
        int last = 0, now = 0;
        int len1, len2, len;
        len1 = nums1.length;
        len2 = nums2.length;
        len = len1 + len2;
        int startLen1 = 0, startLen2 = 0;

        for (int i = 0; i < len / 2 + 1; i++) {
            last = now;
            if (startLen1 < len1 && (startLen2 >= len2 || nums1[startLen1] < nums2[startLen2])) {
                now = nums1[startLen1++];
            } else {
                now = nums2[startLen2++];
            }
        }
        if (len % 2 == 0) {
            return 1.0 * (last + now) / 2;
        } else {
            return 1.0 * now;
        }
    }
}
// @lc code=end
