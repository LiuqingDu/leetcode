/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummp = new ListNode();
        dummp.next = head;
        ListNode last = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val > last.val) {
                last = last.next;
                cur = cur.next;
            } else {
                ListNode pre = dummp;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = last.next;
            }
        }

        return dummp.next;

    }
}
// @lc code=end

