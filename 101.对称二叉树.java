/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 * 
 * started at 2020-04-01 15:22:36
 *
 * finished at 2020-04-01 16:30:04
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (50.52%)
 * Likes:    687
 * Dislikes: 0
 * Total Accepted:    115K
 * Total Submissions: 227.2K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 说明:
 * 
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doRecursive(root.left, root.right);
    }

    // 比较左右子树是否相同
    private boolean doRecursive(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doRecursive(root1.right, root2.left) && doRecursive(root1.left, root2.right);
    }
}
// @lc code=end
