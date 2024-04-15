/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head, p2 = head.next, b = p2;
        while (p1.next != null && p2.next != null) {
            p1.next = p1.next.next;
            if (p1.next != null) {
                p1 = p1.next;
            }
            p2.next = p2.next.next;
            if (p2.next != null) {
                p2 = p2.next;
            }
        }

        p1.next = b;

        return head;

    }
}
// @lc code=end

