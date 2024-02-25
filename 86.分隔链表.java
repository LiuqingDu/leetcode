/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {

        ListNode dummpSmall =  new ListNode();
        ListNode pSmall = dummpSmall;
        ListNode dummpLarge = new ListNode();
        ListNode pLarge = dummpLarge;

        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                pSmall.next = p;
                pSmall = pSmall.next;
            } else {
                pLarge.next = p;
                pLarge = pLarge.next;
            }
            p = p.next;
        }

        pSmall.next = dummpLarge.next;
        pLarge.next = null;

        return dummpSmall.next;

    }
}
// @lc code=end

