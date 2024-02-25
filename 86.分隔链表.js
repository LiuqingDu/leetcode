/*
 * @lc app=leetcode.cn id=86 lang=javascript
 *
 * [86] 分隔链表
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
 * @param {number} x
 * @return {ListNode}
 */
var partition = function(head, x) {

    let smallDummp = new ListNode();
    let largeDummp = new ListNode();
    let pSmall = smallDummp;
    let pLarge = largeDummp;
    
    let p = head;
    while (p) {
        if (p.val < x) {
            pSmall.next = p;
            pSmall = pSmall.next;
        } else {
            pLarge.next = p;
            pLarge = pLarge.next;
        }
        p = p.next;
    }

    pLarge.next = null;
    pSmall.next = largeDummp.next;

    return smallDummp.next;

};
// @lc code=end

