/*
 * @lc app=leetcode.cn id=148 lang=javascript
 *
 * [148] 排序链表
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
var sortList = function(head) {

    let merge = function(l1, l2) {
        let dummy = new ListNode();
        let pre = dummy;
        while (l1 && l2) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1) {
            pre.next = l1;
        }
        if (l2) {
            pre.next = l2;
        }
        return dummy.next;
    }

    let sort = function(head) {

        if (!head || !head.next) {
            return head;
        }

        let slow = head, fast = head;
        let preSlow = null;
        while (fast && fast.next) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // preSlow points to the last node of the 
        // first half link.
        // preSlow.next = null will break the link
        // to two parts. otherwise the sort()
        // will always go through the entire link
        // rather than the half.
        preSlow.next = null;
        let l = sort(head);
        let r = sort(slow);

        return merge(l, r);
    }

    return sort(head);

};
// @lc code=end

