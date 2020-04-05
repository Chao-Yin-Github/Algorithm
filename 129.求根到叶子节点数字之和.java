/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 * 
 * started at 2020-04-04 23:57:47
 * 
 * finished at 2020-04-05 00:09:21
 *
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/description/
 *
 * algorithms
 * Medium (62.34%)
 * Likes:    125
 * Dislikes: 0
 * Total Accepted:    22.6K
 * Total Submissions: 36.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 
 * 计算从根到叶子节点生成的所有数字之和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 
 * 示例 2:
 * 
 * 输入: [4,9,0,5,1]
 * ⁠   4
 * ⁠  / \
 * ⁠ 9   0
 * / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int tempSum) {
        if (root == null) {
            return;
        }
        tempSum = tempSum * 10 + root.val;
        helper(root.left, tempSum);
        helper(root.right, tempSum);
        if (root.left == null && root.right == null) {
            sum += tempSum;
        }
        return;
    }
}
// @lc code=end
