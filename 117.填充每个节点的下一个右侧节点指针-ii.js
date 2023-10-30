/*
 * @lc app=leetcode.cn id=117 lang=javascript
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val, left, right, next) {
 *    this.val = val === undefined ? null : val;
 *    this.left = left === undefined ? null : left;
 *    this.right = right === undefined ? null : right;
 *    this.next = next === undefined ? null : next;
 * };
 */

/**
 * @param {Node} root
 * @return {Node}
 */
var connect = function(root) {

    if (!root) {
        return root;
    }

    let queue = [];
    queue.push(root);

    while(queue.length) {
        let n = queue.length;

        let right = null;
        for (let i = 0; i < n; i++) {
            let node = queue.shift();
            node.next = right;
            right = node;
            if (node.right) {
                queue.push(node.right);
            }
            if (node.left) {
                queue.push(node.left);
            }
        }
    }

    return root;
    
};
// @lc code=end

