/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 * 
 * started at 2020-03-27 12:21:36
 * 
 * finished at 2020-03-27 12:39:39
 *
 * https://leetcode-cn.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (48.17%)
 * Likes:    92
 * Dislikes: 0
 * Total Accepted:    21.3K
 * Total Submissions: 44.2K
 * Testcase Example:  '16'
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 16
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: false
 * 
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * 
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        // 结束循环说明没有1,全为0
        while (num != 0) {
            if ((num & 1) == 1) {
                // break 时:找到第一个为1的偶数位
                break;
            }
            num = num >>> 1;
            // 如果有奇数位为1就立刻返回 false
            if ((num & 1) == 1) {
                return false;
            }
            num = num >>> 1;
        }
        // 如果没有其它的1返回 true
        if ((num & (num - 1)) == 0) {
            return true;
            // 反之返回 false
        } else {
            return false;
        }
    }
}
// @lc code=end
