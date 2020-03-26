/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 *
 * started at 2020-03-26 22:13:22
 * 
 * finished at 2020-03-26 22:16:17
 * 
 * https://leetcode-cn.com/problems/hamming-distance/description/
 *
 * algorithms
 * Easy (75.28%)
 * Likes:    254
 * Dislikes: 0
 * Total Accepted:    46.7K
 * Total Submissions: 62K
 * Testcase Example:  '1\n4'
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 
 * 注意：
 * 0 ≤ x, y < 2^31.
 * 
 * 示例:
 * 
 * 
 * 输入: x = 1, y = 4
 * 
 * 输出: 2
 * 
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ⁠      ↑   ↑
 * 
 * 上面的箭头指出了对应二进制位不同的位置。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int sum = 0;
        x ^= y;
        for (int i = 0; i < 32; i++, x = x >>> 1) {
            if ((1 & x) == 1) {
                sum++;
            }
        }
        return sum;
    }
}
// @lc code=end
