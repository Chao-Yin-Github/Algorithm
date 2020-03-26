/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 * 
 * started at 2020-03-26 22:29:35
 * 
 * finished at 2020-03-26 22:43:54
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (47.78%)
 * Likes:    173
 * Dislikes: 0
 * Total Accepted:    51.4K
 * Total Submissions: 107.5K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == Integer.MIN_VALUE) {
            return false;
        }
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
