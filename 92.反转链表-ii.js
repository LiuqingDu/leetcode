/*
 * @lc app=leetcode.cn id=92 lang=javascript
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
 */
var reverseBetween = function(head, left, right) {

    let successor;

    let reverseK = function(head, k) {
        if (k === 1) {
            successor = head.next;
            return head;
        }

        let last = reverseK(head.next, k - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    if (left == 1) {
        return reverseK(head, right);
    } else {
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

};
// @lc code=end

