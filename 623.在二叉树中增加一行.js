/*
 * @lc app=leetcode.cn id=623 lang=javascript
 *
 * [623] 在二叉树中增加一行
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} val
 * @param {number} depth
 * @return {TreeNode}
 */
var addOneRow = function(root, val, depth) {
    if (depth === 1) {
        const newRoot = new TreeNode(val);
        newRoot.left = root;
        return newRoot;
    }
    
    const queue = [];
    queue.push(root);
    let currentDepth = 1;
    
    while (queue.length > 0 && currentDepth < depth - 1) {
        const size = queue.length;
        for (let i = 0; i < size; i++) {
            const currentNode = queue.shift();
            if (currentNode.left) queue.push(currentNode.left);
            if (currentNode.right) queue.push(currentNode.right);
        }
        currentDepth++;
    }
    
    while (queue.length > 0) {
        const currentNode = queue.shift();
        const newLeft = new TreeNode(val);
        const newRight = new TreeNode(val);
        
        newLeft.left = currentNode.left;
        newRight.right = currentNode.right;
        
        currentNode.left = newLeft;
        currentNode.right = newRight;
    }
    
    return root;
};
// @lc code=end

