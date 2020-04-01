import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 * 
 * started at 2020-04-01 17:11:47
 * 
 * finished at 2020-04-01 17:57:39
 * 
 * tips: 和 I 不一样,这里使用的是 dfs
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (64.61%)
 * Likes:    211
 * Dislikes: 0
 * Total Accepted:    49.3K
 * Total Submissions: 76.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    LinkedList<List<Integer>> lists = new LinkedList<List<Integer>>();
    int level;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return lists;
        }
        doRecursive(root, 0);
        return lists;
    }

    private void doRecursive(TreeNode root, int level) {
        if (level == lists.size()) {
            lists.addFirst(new ArrayList<>());
        }

        lists.get(lists.size() - level - 1).add(root.val);

        if (root.left != null) {
            doRecursive(root.left, level + 1);
        }
        if (root.right != null) {
            doRecursive(root.right, level + 1);
        }
    }
}
// @lc code=end
