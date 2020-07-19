/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (33.52%)
 * Likes:    448
 * Dislikes: 0
 * Total Accepted:    43.2K
 * Total Submissions: 127K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 */

// @lc code=start
// 动归竟然超时了,题解说要用贪心
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] 表示到达第 i 个位置所需要的跳跃次数
        int[] dp = new int[nums.length];
        // 第一个默认为 0
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            // 初始化默认不可达
            dp[i] = -1;
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && nums[j] + j >= i) {
                    if (dp[i] == -1) {
                        dp[i] = dp[j] + 1;
                    } else {
                        dp[i] = Math.min(dp[j] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }
}
// @lc code=end
