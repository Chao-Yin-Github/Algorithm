import java.util.*;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 *
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * algorithms
 * Medium (71.18%)
 * Likes:    248
 * Dislikes: 0
 * Total Accepted:    60.7K
 * Total Submissions: 85.2K
 * Testcase Example:  '[3,1,4,null,2]\n1'
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 
 * 示例 1:
 * 
 * 输入: root = [3,1,4,null,2], k = 1
 * ⁠  3
 * ⁠ / \
 * ⁠1   4
 * ⁠ \
 * 2
 * 输出: 1
 * 
 * 示例 2:
 * 
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * ⁠      5
 * ⁠     / \
 * ⁠    3   6
 * ⁠   / \
 * ⁠  2   4
 * ⁠ /
 * ⁠1
 * 输出: 3
 * 
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        // 降序排列,最大堆
        Queue<Integer> queue = new PriorityQueue<Integer>((Integer item1, Integer item2) -> {
            return item2 - item1;
        });
        build(queue, root, k);
        return queue.poll();
    }

    private void build(Queue<Integer> queue, TreeNode root, int k) {
        if (queue.size() >= k) {
            return;
        }
        if (root == null) {
            return;
        }
        build(queue, root.left, k);
        if (queue.size() >= k) {
            return;
        }
        queue.offer(root.val);
        build(queue, root.right, k);
    }
}
// @lc code=end
