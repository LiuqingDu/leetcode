/*
 * @lc app=leetcode.cn id=725 lang=javascript
 *
 * [725] 分隔链表
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
 * @param {number} k
 * @return {ListNode[]}
 */
var splitListToParts = function(head, k) {
    const result = new Array(k).fill(null);
    
    let length = 0;
    let current = head;
    while (current !== null) {
        length++;
        current = current.next;
    }

    const partSize = Math.floor(length / k);
    let extraNodes = length % k;

    current = head;
    for (let i = 0; i < k && current !== null; i++) {
        result[i] = current;
        let currentPartSize = partSize + (extraNodes > 0 ? 1 : 0);
        extraNodes--;

        for (let j = 1; j < currentPartSize; j++) {
            if (current !== null) current = current.next;
        }

        if (current !== null) {
            let nextPart = current.next;
            current.next = null;
            current = nextPart;
        }
    }

    return result;
};
// @lc code=end

