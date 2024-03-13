/*
 * @lc app=leetcode.cn id=147 lang=javascript
 *
 * [147] 对链表进行插入排序
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
var insertionSortList = function(head) {

    if (!head) {
        return head;
    }

    let dummp = new ListNode();
    dummp.next = head;
    let last = head;
    let cur = head.next;

    while (cur) {
        if (cur.val > last.val) {
            last = last.next;
            cur = cur.next;
        } else {
            let p = dummp;
            while (p.next.val < cur.val) {
                p = p.next;
            }
            last.next = cur.next;
            cur.next = p.next;
            p.next = cur;
            cur = last.next;
        }
    }

    return dummp.next;

};
// @lc code=end

