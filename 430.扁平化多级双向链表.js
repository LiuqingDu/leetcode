/*
 * @lc app=leetcode.cn id=430 lang=javascript
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/**
 * // Definition for a _Node.
 * function _Node(val,prev,next,child) {
 *    this.val = val;
 *    this.prev = prev;
 *    this.next = next;
 *    this.child = child;
 * };
 */

/**
 * @param {_Node} head
 * @return {_Node}
 */
var flatten = function(head) {
    let dummy = new Node();
    dummy.next = head;
    while (head) {
        if (!head.child) {
            head = head.next;
        } else {
            let tmp = head.next;
            let childHead = flatten(head.child);
            head.next = childHead;
            childHead.prev = head;
            head.child = null;

            while (head.next) {
                head = head.next;
            }
            head.next = tmp;

            if (tmp) {
                tmp.prev = head;
            }
            head = tmp;
        }
    }
    return dummy.next;
};
// @lc code=end

