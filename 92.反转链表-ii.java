/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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

    // 反转段结束后的第一个节点
    ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 如果从第一个结点开始翻转，直接调用翻转函数
        if (left == 1) {
            return reverseN(head, right);
        }
        // 递归直到找到翻转段的开头
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // 反转前 n 个节点，返回反转后的头节点（图案中最右边的节点）
    private ListNode reverseN(ListNode head, int right) {
        // 如果只有一个节点，直接返回自己
        if (right == 1) {
            successor = head.next;
            return head;
        }
        // 把后面的n-1个节点翻转，并让后一个节点指向自己
        ListNode last = reverseN(head.next, right - 1);
        head.next.next = head;
        // 自己指向反转段的后一个节点
        head.next = successor;
        return last;
    }
}
// @lc code=end

