/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 * 
 * started at 2020-04-02 14:11:23
 * 
 * finished at 2020-04-02 14:48:48
 * 
 * tips: 使用一个新的类存储遍历信息,实现自底向上
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (50.84%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    62.6K
 * Total Submissions: 122.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 
 * 
 * 示例 1:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回 true 。
 * 
 * 示例 2:
 * 
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * 返回 false 。
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class TreeNodeInfo {
    int height;
    boolean balanced;
    TreeNodeInfo treeNodeInfoLeft;
    TreeNodeInfo treeNodeInfoRight;

    public int getHeight() {
        return height;
    }

    public boolean getBalanced() {
        return balanced;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBalanced(boolean balanced) {
        this.balanced = balanced;
    }

    public String toString() {
        return "[height=" + height + ",balanced=" + balanced + "]\n";
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root).getBalanced();
    }

    private TreeNodeInfo helper(TreeNode root) {
        if (root == null) {
            TreeNodeInfo treeNodeInfo = new TreeNodeInfo();
            treeNodeInfo.setBalanced(true);
            treeNodeInfo.setHeight(0);
            return treeNodeInfo;
        }
        TreeNodeInfo left = helper(root.left);
        if (!left.getBalanced()) {
            TreeNodeInfo treeNodeInfo = new TreeNodeInfo();
            treeNodeInfo.setBalanced(false);
            treeNodeInfo.setHeight(left.height + 1);
            return treeNodeInfo;
        }
        TreeNodeInfo right = helper(root.right);
        if (!right.getBalanced()) {
            TreeNodeInfo treeNodeInfo = new TreeNodeInfo();
            treeNodeInfo.setBalanced(false);
            treeNodeInfo.setHeight(right.height + 1);
            return treeNodeInfo;
        }
        if (Math.abs(left.getHeight() - right.getHeight()) < 2) {
            TreeNodeInfo treeNodeInfo = new TreeNodeInfo();
            treeNodeInfo.setBalanced(true);
            treeNodeInfo.setHeight(Math.max(left.getHeight(), right.getHeight()) + 1);
            return treeNodeInfo;
        }
        TreeNodeInfo treeNodeInfo = new TreeNodeInfo();
        treeNodeInfo.setBalanced(false);
        treeNodeInfo.setHeight(Math.abs(left.getHeight() - right.getHeight()) + 1);
        // System.out.println(treeNodeInfo.toString());
        return treeNodeInfo;
    }
}
// @lc code=end
