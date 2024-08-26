/*
 * @lc app=leetcode.cn id=872 lang=javascript
 *
 * [872] 叶子相似的树
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
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function(root1, root2) {
    let traversal = function(node) {
        let list = [];
        let queue = [];
        while (node || queue.length) {
            while (node) {
                queue.push(node);
                node = node.left;
            }
            node = queue.pop();

            if (!node.left && !node.right) {
                list.push(node.val);
            }

            node = node.right;
        }
        return list;
    }

    let list1 = traversal(root1)
    let list2 = traversal(root2);

    if (list1.length !== list2.length) {
        return false;
    }

    for (let i = 0; i < list1.length; i++) {
        if (list1[i] !== list2[i]) {
            return false;
        }
    }
    return true;

};
// @lc code=end

