import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * started at 2020-03-30 20:57:16
 * 
 * finished at 2020-03-30 21:33:43
 * 
 * modified at 2020-03-30 22:11:43 no recursive method
 * 
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (70.61%)
 * Likes:    440
 * Dislikes: 0
 * Total Accepted:    130K
 * Total Submissions: 183.8K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> list = new ArrayList<>();

        boolean visitedLeft = false;
        while (root != null) {
            // 当存在左子树时,将这个结点压入
            if (root.left != null && !visitedLeft) {
                stack.push(root);
                root = root.left;
            } else {
                list.add(root.val);
                // 当存在右子树时,将这个中间结点压入
                if (root.right != null) {
                    visitedLeft = false;
                    root = root.right;
                } else {
                    if (!stack.isEmpty()) {
                        root = stack.pop();
                        visitedLeft = true;
                    } else {
                        root = null;
                    }
                }
            }
        }
        return list;
    }
}