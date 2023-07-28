/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 快慢指针找到中点
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果fast不为空，那么总数就是奇数个，
        // slow正好指向正中间的那个，需要往前走一步
        if (fast != null) {
            slow = slow.next;
        }
        // 快指针回到开头，慢指针把后半部分翻转
        fast = head;
        slow = reverse(slow);
        
        // 判断是否相同
        while(slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        // 恢复后半段链表
        slow = reverse(slow);

        return true;
    }

    // 翻转链表
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode last = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }
}
// @lc code=end

