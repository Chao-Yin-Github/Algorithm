/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 * 
 * 位运算太难了
 *
 * started at 2020-03-26 18:04:20
 * 
 * finished at 2020-03-26 19:47:19
 * 
 * https://leetcode-cn.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (66.01%)
 * Likes:    281
 * Dislikes: 0
 * Total Accepted:    23.8K
 * Total Submissions: 36K
 * Testcase Example:  '[2,2,3,2]'
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,3,2]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * 
 */

// @lc code=start

class Solution {
    public int singleNumber(int[] nums) {
        // 实现一个状态机，使得每个位的对应状态每出现3次1复原
        // time: 0 - 1 - 2
        // once: 0 - 1 - 0
        // twice: 0 - 0 - 1
        // once中的位出现了3n+1次，twice中的位出现了3n次
        int once = 0, twice = 0;
        for (int n : nums) {
            // 就每个位而言：
            // 只有在twice位不为1的情况下，once才可以进位
            once = ~twice & (once ^ n);
            // 只有在once已经从0->1,再由1->0的情况下才能改变twice
            twice = ~once & (twice ^ n);
            System.out.println(once + " " + twice);
        }
        return once;
    }
}
// @lc code=end
