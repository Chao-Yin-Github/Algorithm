import java.util.*;
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (74.46%)
 * Likes:    713
 * Dislikes: 0
 * Total Accepted:    130K
 * Total Submissions: 170.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        helper(nums, lists, new ArrayList<Integer>());
        return lists;
    }

    private void helper(int[] nums, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        Arrays.stream(nums).forEach(item -> {
            if (!list.contains(item)) {
                list.add(item);
                helper(nums, lists, list);
                list.remove(list.size() - 1);
            }
        });
    }
}
// @lc code=end
