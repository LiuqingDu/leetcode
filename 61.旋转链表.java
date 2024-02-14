/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode p = head;
        int i = 0;
        while (p != null) {
            i++;
            p = p.next;
        }
        k = k % i;

        ListNode dummp = new ListNode();
        dummp.next = head;
        ListNode fast = dummp;

        while (k > 0) {
            fast = fast.next;
            k--;
        }

        ListNode slow = dummp;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
// @lc code=end

