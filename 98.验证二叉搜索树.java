/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 * 
 * started at 2020-04-04 15:37:23
 * 
 * finished at 2020-04-04 16:55:32
 * 
 * tips: 卡边界值好饿心啊! 不能用 Integer.MAX_VALUE
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (29.45%)
 * Likes:    485
 * Dislikes: 0
 * Total Accepted:    86.8K
 * Total Submissions: 292.9K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val <= left || root.val <= root.left.val) {
                return false;
            } else {
                left = (long) Math.min(left, root.val);
            }
        }
        if (root.right != null) {
            if (root.right.val >= right || root.val >= root.right.val) {
                return false;
            } else {
                right = (long) Math.max(right, root.val);
            }
        }
        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }
}
// @lc code=end
