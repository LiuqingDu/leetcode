/*
 * @lc app=leetcode.cn id=234 lang=javascript
 *
 * [234] 回文链表
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
 * @return {boolean}
 */
var isPalindrome = function(head) {

    let reverse = function(node) {
        if (!node || !node.next) {
            return node;
        }
        let last = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    let slow = head, fast = head;

    while(fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
    }

    if (fast) {
        slow = slow.next;
    }

    fast = head;
    slow = reverse(slow);

    while(slow) {
        if (slow.val !== fast.val) {
            return false;
        }
        slow = slow.next;
        fast = fast.next;
    }

    return true;

};
// @lc code=end

