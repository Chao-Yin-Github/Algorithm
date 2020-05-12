/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.29%)
 * Likes:    360
 * Dislikes: 0
 * Total Accepted:    45.5K
 * Total Submissions: 193.8K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return s == null ? 0 : 1;
        }
        // dp[i] 表示对于前 i 个字母有多少种解码方式
        int[] dp = new int[s.length() + 1];
        // 空串有1种解密方式
        dp[0] = 1;
        char[] ss = s.toCharArray();
        for (int i = 1; i <= ss.length; i++) {
            // i-1 位置的数字的值
            int single = ss[i - 1] - '0';
            if (single > 0 && single < 10) {
                dp[i] = dp[i - 1];
            }
            if (i > 1) {
                // twice 是第 i-2,i-1,组合起来的合法数字
                // 因为 dp[i] = dp [i -1] +dp[i-2];
                int twice = single + (ss[i - 2] - '0') * 10;
                if (twice <= 26 && twice >= 10) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end
