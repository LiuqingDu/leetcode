/*
 * @lc app=leetcode.cn id=1019 lang=javascript
 *
 * [1019] 链表中的下一个更大节点
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
 * @return {number[]}
 */
var nextLargerNodes = function(head) {
    const ans = [];
    const stack = [];

    let cur = head;
    let idx = -1;
    while (cur) {
        ++idx;
        ans.push(0);
        while (stack.length && stack[stack.length - 1][0] < cur.val) {
            ans[stack.pop()[1]] = cur.val;
        }
        stack.push([cur.val, idx]);
        cur = cur.next;
    }

    const size = ans.length;
    const arr = new Array(size);
    for (let i = 0; i < size; ++i) {
        arr[i] = ans[i];
    }
    return arr;
};
// @lc code=end

