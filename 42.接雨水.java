import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 * 
 * started at 2020-03-23 20:05:30
 * 
 * finished at 2020-03-24 13:55:43
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (49.46%)
 * Likes:    945
 * Dislikes: 0
 * Total Accepted:    64.5K
 * Total Submissions: 130.5K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int length = height.length;
        if (height == null || length == 0) {
            return 0;
        }
        int left = 0;
        int left_max = height[left];
        int right = length - 1;
        int right_max = height[right];
        int sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    sum += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    sum += right_max - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}