/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 *
 * started at 2020-03-26 16:51:08
 * 
 * finished at 
 * 
 * https://leetcode-cn.com/problems/set-mismatch/description/
 *
 * algorithms
 * Easy (41.35%)
 * Likes:    76
 * Dislikes: 0
 * Total Accepted:    11.3K
 * Total Submissions: 27.2K
 * Testcase Example:  '[1,2,2,4]'
 *
 * 集合 S 包含从1到 n
 * 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * 
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 
 * 
 * 注意:
 * 
 * 
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        int repeat = nums.length ^ 0 ^ slow;
        for (int i = 0; i < nums.length; i++) {
            repeat ^= i ^ nums[i];
        }
        System.out.println();

        return new int[] { slow, repeat == 0 ? nums.length : repeat };
    }
}
// @lc code=end
