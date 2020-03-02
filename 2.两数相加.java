/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (35.03%)
 * Likes:    2772
 * Dislikes: 0
 * Total Accepted:    171.8K
 * Total Submissions: 490.3K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        while (l1 != null && l2 != null) {
            System.out.println(l1.val + " " + l2.val);
            l3.next = new ListNode((l3.next == null ? 0 : l3.next.val) + l1.val + l2.val);
            System.out.println(l3.next.val);
            if (l3.next.val >= 10) {
                l3.next.next = new ListNode(l3.next.val / 10);
                l3.next.val = l3.next.val % 10;
            }
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                l3.next = new ListNode(l1.val + (l3.next == null ? 0 : l3.next.val));
                if (l3.next.val >= 10) {
                    l3.next.next = new ListNode(l3.next.val / 10);
                    l3.next.val = l3.next.val % 10;
                }
                l3 = l3.next;
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
                l3.next = new ListNode(l2.val + (l3.next == null ? 0 : l3.next.val));
                if (l3.next.val >= 10) {
                    l3.next.next = new ListNode(l3.next.val / 10);
                    l3.next.val = l3.next.val % 10;
                }
                l2 = l2.next;
                l3 = l3.next;
            }
        }
        return head.next;
    }
}
