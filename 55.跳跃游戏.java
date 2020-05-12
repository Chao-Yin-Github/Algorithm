/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (38.41%)
 * Likes:    638
 * Dislikes: 0
 * Total Accepted:    105.1K
 * Total Submissions: 265.5K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        // dp[i] 代表能否到达第 i 个下标的位置
        boolean[] dp = new boolean[nums.length];
        // 第零个肯定可以到
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            // 从 0 到 i-1,尝试能否有一个到达 i
            for (int j = 0; j < i; j++) {
                // 如果可以到达
                if (dp[j] && nums[j] + j >= i) {
                    // i 置为 true
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
// @lc code=end
