/*
 * @lc app=leetcode.cn id=328 lang=javascript
 *
 * [328] 奇偶链表
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
var oddEvenList = function(head) {

    if (!head || !head.next) {
        return head;
    }

    let p1 = head, p2 = head.next;
    let b = p2;
    while (p1.next && p2.next) {
        p1.next = p1.next.next;
        if (p1.next) {
            p1 = p1.next;
        }
        p2.next = p2.next.next;
        if (p2.next) {
            p2 = p2.next;
        }
    }

    p1.next = b;
    
    return head;

};
// @lc code=end

