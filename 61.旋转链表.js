/*
 * @lc app=leetcode.cn id=61 lang=javascript
 *
 * [61] 旋转链表
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
 * @param {number} k
 * @return {ListNode}
 */
var rotateRight = function(head, k) {
    if (!head) {
        return head;
    }

    let i = 0;
    let p = head;
    while (p) {
        i++;
        p = p.next;
    }

    k = k % i;

    let dummp = new ListNode();
    dummp.next = head;
    let fast = dummp;
    while (k > 0) {
        fast = fast.next;
        k--;
    }

    let slow = dummp;
    while (fast.next) {
        slow = slow.next;
        fast = fast.next;
    }

    fast.next = head;
    head = slow.next;
    slow.next = null;

    return head;

};
// @lc code=end

