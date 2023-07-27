/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // 快慢指针，当两个指针的值不同时，将慢指针的next指向快指针
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null) {
            if (slow.val == fast.val) {
                // 注意这里需要把slow.next置空，
                // 否则像 1,2,3,3,3 这种的就会无法把第一个3和后面的3拆开
                slow.next = null;
                fast = fast.next;
            } else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }

        return head;

    }
}
// @lc code=end
