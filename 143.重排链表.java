/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverseList(head2);

        while (head2 != null) {
            ListNode tmp = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = head.next.next;
            head2 = tmp;
        }

    }

    private ListNode reverseList(ListNode node) {
        if (node == null) {
            return node;
        }

        ListNode tail = node;
        node = node.next;

        tail.next = null;

        while (node != null) {
            ListNode tmp = node.next;
            node.next = tail;
            tail = node;
            node = tmp;
        }

        return tail;

    }
}
// @lc code=end

