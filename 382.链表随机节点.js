/*
 * @lc app=leetcode.cn id=382 lang=javascript
 *
 * [382] 链表随机节点
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
 */
var Solution = function(head) {

    this.head = head;

};

/**
 * @return {number}
 */
Solution.prototype.getRandom = function() {

    let i = 0;
    let cur = this.head
    let res = cur;

    while (cur) {
        i++;
        if (Math.floor(Math.random() * i) === 0) {
            res = cur;
        }
        cur = cur.next;
    }

    return res.val;

};

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(head)
 * var param_1 = obj.getRandom()
 */
// @lc code=end

