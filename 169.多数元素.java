/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 *
 * started at 2020-03-26 21:06:21
 * 
 * finished at 2020-03-26 21:23:11
 * 
 * 摩尔投票法:<https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/>
 * 
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (62.74%)
 * Likes:    530
 * Dislikes: 0
 * Total Accepted:    148.3K
 * Total Submissions: 236.2K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer major = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
                continue;
            }
            if (major != nums[i]) {
                count--;
            } else {
                count++;
            }
        }
        return major;
    }

}
// @lc code=end
