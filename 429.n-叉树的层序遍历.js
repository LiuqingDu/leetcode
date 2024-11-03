/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/**
 * // Definition for a _Node.
 * function _Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {_Node|null} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (root === null) {
        return [];
    }

    const ans = [];
    const queue = [root];
    
    while (queue.length > 0) {
        const n = queue.length;
        const vals = [];
        for (let i = 0; i < n; i++) {
            const node = queue.shift();
            vals.push(node.val);
            queue.push(...node.children);
        }
        ans.push(vals);
    }

    return ans;
};
// @lc code=end

