/*
 * @lc app=leetcode.cn id=513 lang=javascript
 *
 * [513] 找树左下角的值
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
 * @return {number}
 */
var findBottomLeftValue = function(root) {
    let queue = [root];
    let bottomLeftValue = root.val;

    while (queue.length > 0) {
        let levelSize = queue.length;

        for (let i = 0; i < levelSize; i++) {
            let current = queue.shift();

            if (i === 0) {
                bottomLeftValue = current.val;
            }

            if (current.left) queue.push(current.left);
            if (current.right) queue.push(current.right);
        }
    }

    return bottomLeftValue;
};
// @lc code=end

