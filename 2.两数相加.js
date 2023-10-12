/*
 * @lc app=leetcode.cn id=2 lang=javascript
 *
 * [2] 两数相加
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
    let addition = 0;
    let dump = new ListNode(0, null);
    let head = dump;

    // 只要还有数字就继续计算，直到两个数字都到头为止
    while (l1 || l2) {
        // 如果其中一个数字已经到头了，按照0处理
        if (!l1) {
            l1 = new ListNode(0, null);
        } else if (!l2) {
            l2 = new ListNode(0, null);
        }

        let sum = l1.val + l2.val + addition;
        if (sum >= 10) {
            addition = 1;
            sum -= 10;
        } else {
            addition = 0;
        }

        let node = new ListNode(sum, null);
        head.next = node;
        head = head.next;
        l1 = l1.next;
        l2 = l2.next;
    }

    // 如果都到头了还有进位，就再加上这个进位
    if (addition) {
        let node = new ListNode(1, null);
        head.next = node;
    }

    return dump.next;

};
// @lc code=end

