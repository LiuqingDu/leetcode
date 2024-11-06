/*
 * @lc app=leetcode.cn id=445 lang=javascript
 *
 * [445] 两数相加 II
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
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    const stack1 = [];
    const stack2 = [];

    while (l1 !== null) {
        stack1.push(l1.val);
        l1 = l1.next;
    }
    while (l2 !== null) {
        stack2.push(l2.val);
        l2 = l2.next;
    }

    let head = null;
    let carry = 0;

    while (stack1.length > 0 || stack2.length > 0 || carry !== 0) {
        let sum = carry;

        if (stack1.length > 0) {
            sum += stack1.pop();
        }
        if (stack2.length > 0) {
            sum += stack2.pop();
        }

        carry = Math.floor(sum / 10);
        const val = sum % 10;

        const newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    return head;
};
// @lc code=end

