import java.util.*;
/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (49.49%)
 * Likes:    677
 * Dislikes: 0
 * Total Accepted:    125K
 * Total Submissions: 241.8K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        boolean hasAdd = true;
        while (hasAdd) {
            hasAdd = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    queue.offer(lists[i].val);
                    lists[i] = lists[i].next;
                    hasAdd = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            current.next = new ListNode(queue.poll());
            current = current.next;
        }
        return head.next;
    }
}
// @lc code=end
