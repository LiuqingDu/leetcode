/*
 * @lc app=leetcode.cn id=143 lang=javascript
 *
 * [143] 重排链表
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
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {
    let slow = head;
    let fast = head;

    while (fast.next && fast.next.next) {
        slow = slow.next;
        fast = fast.next.next;
    }

    let head2 = slow.next;
    slow.next = null;

    let reverseLink = function(node) {
        if (!node || !node.next) {
            return node;
        }

        let head = reverseLink(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    head2 = reverseLink(head2);

    let dummp = new ListNode();
    let p = dummp;

    while (head && head2) {
        p.next = head;
        head = head.next;
        p = p.next;

        p.next = head2;
        head2 = head2.next;
        p = p.next;
    }

    if (head) {
        p.next = head;
    }

    return dummp.next;

};
// @lc code=end

