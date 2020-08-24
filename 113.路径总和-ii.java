import java.util.*;
/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (59.01%)
 * Likes:    196
 * Dislikes: 0
 * Total Accepted:    39.6K
 * Total Submissions: 67.1K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        back_track(new ArrayList<Integer>(), lists, root, sum);
        return lists;
    }

    private void back_track(List<Integer> list, List<List<Integer>> lists, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                lists.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
                return;
            }
        }
        back_track(list, lists, root.left, sum);
        back_track(list, lists, root.right, sum);
        list.remove(list.size() - 1);
    }
}
// @lc code=end
