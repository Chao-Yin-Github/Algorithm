import jdk.jfr.Experimental;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点 
 * 
 * started at 2020-03-05 18:24:36
 * almost finished at 2020-03-05 19:03:39
 * accomplished at 2020-03-05 20:22:55
 * 
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (34.84%)
 * Likes:    707
 * Dislikes: 0
 * Total Accepted:    129.8K
 * Total Submissions: 343.7K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 
 * 
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * attention: 虽然报错说没有找到 ListNode,但是不用自己写,上面的说明的内容即是算法需要用到的
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode first = head;
        ListNode next = head;
        int times = 0;
        while (next.next != null && times < n) {
            next = next.next;
            times++;
        }
        while (next.next != null) {
            first = first.next;
            next = next.next;
        }
        // 使用times进行边界处理
        // 对应 [1] 1 或者 [1,2,3] 3 这种情况
        if (times == n) {
            first.next = first.next.next;
            return head;
        } else {
            return first.next;
        }
    }
}
// @lc code=end
