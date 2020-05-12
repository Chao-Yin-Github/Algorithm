/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (37.61%)
 * Likes:    482
 * Dislikes: 0
 * Total Accepted:    48.7K
 * Total Submissions: 128K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int maxNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = min[i] = nums[i];
            if (nums[i] >= 0) {
                max[i] = Math.max(max[i], nums[i] * max[i - 1]);
                min[i] = Math.min(min[i], nums[i] * min[i - 1]);
            } else {
                max[i] = Math.max(max[i], nums[i] * min[i - 1]);
                min[i] = Math.min(min[i], nums[i] * max[i - 1]);
            }
            maxNumber = Math.max(max[i], maxNumber);
        }
        return maxNumber;
    }
}
// @lc code=end
