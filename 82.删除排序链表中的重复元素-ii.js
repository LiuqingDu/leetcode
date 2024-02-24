/*
 * @lc app=leetcode.cn id=82 lang=javascript
 *
 * [82] 删除排序链表中的重复元素 II
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
var deleteDuplicates = function(head) {
    // 迭代方法看java版
    // 下面是递归版，递归版比较容易理解
    // 思路是，处理当前节点，然后把剩下的节点交给下一层递归

    // base case
    if (!head || !head.next) {
        return head;
    }

    // 如果当前节点跟下一个节点相同，则当前的数字都不能要
    // 找到下一个数字，然后递归处理下一个数字的节点
    if (head.val == head.next.val) {
        while (head.next && head.val == head.next.val) {
            head = head.next;
        }
        // 此时head指向当前数字最后一个元素，head.next指向下一个数字
        return deleteDuplicates(head.next);
    }

    // 如果当前节点跟下一个不同，则当前节点需要保留，
    // 然后处理剩下的节点，把剩下的部分拼在当前节点后面
    if (head.val != head.next.val) {
        head.next = deleteDuplicates(head.next);
        return head;
    }

};
// @lc code=end

