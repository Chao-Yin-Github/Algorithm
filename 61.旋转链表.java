/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 * 
 * started at 2020-03-19 14:00:35
 * 
 * finished at 2020-03-19 14:49:23
 * 
 * refactor at 2020-03-19 15:49:36
 * 
 * perception: 我首先模拟了一遍,老老实实旋转 k 次,后来发现会超时
 * 
 * 那么想到 k 和链表的长度有关系,那么可以对旋转次数 k 进行优化 k %= length
 * 
 * 然后发现还可以进一步优化:直接根据 k 确定目标头节点的位置,处理一次更新即可
 * 
 * 例如: [1,2,3]\n4
 * 
 * 那么,首先 k = 4%3 = 1 ,那么找到**倒数第一个结点**的前一个结点(之所以是前一个,是因为它将是最后目标结果的最后一个结点,它的 next 为 null)
 * 
 * 把这个前一个结点的 next 结点指向第一个结点,头结点现在已经符合要求,
 * 
 * 再将这个前一个结点的 next 指向 null 即可
 *
 * https://leetcode-cn.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (38.85%)
 * Likes:    220
 * Dislikes: 0
 * Total Accepted:    49.1K
 * Total Submissions: 122.9K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 
 * 
 * 示例 2:
 * 
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * 
 */

// @lc code=start
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    private ListNode rotateLastKth(ListNode head, int lastKth) {
        ListNode previous = head;
        ListNode after = head;
        int count = 0;

        while (after.next != null && count < lastKth) {
            count++;
            after = after.next;
        }

        while (after.next != null) {
            after = after.next;
            previous = previous.next;
        }

        after.next = head;
        head = previous.next;
        previous.next = null;
        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = countLength(head);
        k = k % length;
        if (k == 0) {
            return head;
        }
        return rotateLastKth(head, k);
    }

    private int countLength(ListNode head) {
        int length = 0;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        return length + 1;
    }
}
// @lc code=end
