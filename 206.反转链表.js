/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
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
var reverseList = function(head) {

    let reverse = function(node) {
        if (!node || !node.next) {
            return node;
        }
        let last = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    return reverse(head);

};
// @lc code=end

