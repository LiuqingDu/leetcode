/*
 * @lc app=leetcode.cn id=24 lang=javascript
 *
 * [24] 两两交换链表中的节点
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
 * @return {ListNode}
 */
var swapPairs = function(head) {

    if (!head || !head.next) {
        return head;
    } else {
        let first = head;
        let second = head.next;
        let rest = swapPairs(second.next);
        first.next = rest;
        second.next = first;
        return second;
    }

};
// @lc code=end

