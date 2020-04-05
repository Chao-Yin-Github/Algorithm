import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 * 
 * started at 2020-04-04 17:06:57
 * 
 * finished at 2020-04-06 02:13:09
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (64.58%)
 * Likes:    389
 * Dislikes: 0
 * Total Accepted:    54.3K
 * Total Submissions: 84K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int firstStart, int firstEnd, int secondStart,
            int secondEnd) {
        if (firstStart == firstEnd && secondStart == secondEnd) {
            return new TreeNode(preorder[firstStart]);
        }
        int arrayTwoToFindRoot = secondStart;
        while (inorder[arrayTwoToFindRoot] != preorder[firstStart]) {
            arrayTwoToFindRoot++;
        }
        TreeNode rootNode = new TreeNode(preorder[firstStart]);
        int arrayOneToFindLeftNode = firstStart + 1;
        // 说明有左子树
        if (arrayTwoToFindRoot != secondStart) {
            Set<Integer> set = new HashSet<>(secondEnd - secondStart + 1);
            for (int i = secondStart; i < arrayTwoToFindRoot && i < inorder.length; i++) {
                set.add(inorder[i]);
            }
            while (arrayOneToFindLeftNode <= firstEnd && set.contains(preorder[arrayOneToFindLeftNode])) {
                arrayOneToFindLeftNode++;
            }
            rootNode.left = helper(preorder, inorder, firstStart + 1, arrayOneToFindLeftNode - 1, secondStart,
                    arrayTwoToFindRoot - 1);
        }
        // 如果有右子树
        if (arrayOneToFindLeftNode <= firstEnd && arrayTwoToFindRoot + 1 <= secondEnd) {
            rootNode.right = helper(preorder, inorder, arrayOneToFindLeftNode, firstEnd, arrayTwoToFindRoot + 1,
                    secondEnd);
        }
        return rootNode;
    }
}