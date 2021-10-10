import java.util.*;

/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (67.08%)
 * Likes:    765
 * Dislikes: 0
 * Total Accepted:    95.2K
 * Total Submissions: 141.9K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 示例 1:
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2:
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { thjis.val = val; this.next = next; } }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            tempNode = tempNode.next;
            len++;
        }
        if (len == 1) {
            return head;
        }
        tempNode = head;
        for (int interval = 1; interval <= (len >> 1) + 1; interval++) {
            ListNode newList = new ListNode(-1);
            ListNode newListHead = newList;
            while (head != null) {
                System.out.println("head = " + head.val);
                // 第一个切分
                ListNode current = head;
                tempNode = head;
                int count = 0;
                while (count < interval - 1 && tempNode.next != null) {
                    count++;
                    tempNode = tempNode.next;
                }
                if (tempNode.next == null) {
                    newList.next = tempNode;
                    newList = newList.next;
                    break;
                }
                head = tempNode.next;
                tempNode.next = null;

                ListNode nextNode = head;
                tempNode = head;
                count = 0;
                while (count < interval - 1) {
                    count++;
                    tempNode = tempNode.next;
                }
                head = tempNode.next;
                tempNode.next = null;

                tempNode = merge(current, nextNode);
                print(tempNode);
                if (tempNode != null) {
                    newList.next = tempNode;
                    while (newList != null && newList.next != null) {
                        newList = newList.next;
                    }
                    print(newListHead.next);
                } else {
                    System.out.println("merge is null");
                }
            }
            head = newListHead.next;
        }
        return head;
    }

    private ListNode merge(ListNode current, ListNode nextNode) {
        if (current == null && nextNode == null) {
            return null;
        }
        if (current == null) {
            return nextNode;
        }
        if (nextNode == null) {
            return current;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (current != null && nextNode != null) {
            if (current.val < nextNode.val) {
                temp.next = current;
                temp = temp.next;
                current = current.next;
            } else {
                temp.next = nextNode;
                temp = temp.next;
                nextNode = nextNode.next;
            }
        }
        if (current == null) {
            temp.next = nextNode;
        } else if (nextNode == null) {
            temp.next = current;
        }
        return head.next;
    }

    private void print(ListNode head) {
        System.out.println("log");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("\nend");
    }
}