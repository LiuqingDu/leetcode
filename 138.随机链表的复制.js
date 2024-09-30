/*
 * @lc app=leetcode.cn id=138 lang=javascript
 *
 * [138] 随机链表的复制
 */

// @lc code=start
/**
 * // Definition for a _Node.
 * function _Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {_Node} head
 * @return {_Node}
 */
var copyRandomList = function(head) {
    if (!head) {
        return null;
    }

    let p = head;
    while (p) {
        let newNode = new Node(p.val);
        newNode.next = p.next;
        p.next = newNode;
        p = newNode.next;
    }

    p = head;
    while (p) {
        if (p.random) {
            p.next.random = p.random.next;
        }
        p = p.next.next;
    }

    let dummy = new Node(-1);
    let cur = dummy;
    p = head;

    while (p) {
        cur.next = p.next;
        cur = cur.next;
        p.next = cur.next;
        p = p.next;
    }

    return dummy.next;
};
// @lc code=end

