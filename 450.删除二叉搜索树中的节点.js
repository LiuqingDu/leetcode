/*
 * @lc app=leetcode.cn id=450 lang=javascript
 *
 * [450] 删除二叉搜索树中的节点
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
 * @param {number} key
 * @return {TreeNode}
 */
var deleteNode = function(root, key) {

    if (!root) {
        return root;
    }

    if (root.val === key) {
        if (!root.right) {
            return root.left;
        }
        if (!root.left) {
            return root.right;
        }
        
        let tmp = root.left;
        let cur = root.right;
        while(cur.left) {
            cur = cur.left;
        }
        cur.left = tmp;
        return root.right;
    }

    if (root.val > key) {
        root.left = deleteNode(root.left, key);
    }

    if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }

    return root;

};
// @lc code=end

