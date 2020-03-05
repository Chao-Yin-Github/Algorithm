/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器 
 * 
 * accomplished at 2020-03-04 22:45:28
 * 
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (56.79%)
 * Likes:    918
 * Dislikes: 0
 * Total Accepted:    103.1K
 * Total Submissions: 173.7K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 
 */
// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = -1;
        int sum;
        int temp;
        while (left < right) {
            sum = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(sum, max);
            if (left + 1 == right) {
                break;
            }
            if (height[left] < height[right]) {
                temp = height[left];
                while (left < right && temp >= height[left]) {
                    left++;
                }
            } else {
                temp = height[right];
                while (left < right && temp >= height[right]) {
                    right--;
                }
            }
        }
        return max;
    }
}
// @lc code=end