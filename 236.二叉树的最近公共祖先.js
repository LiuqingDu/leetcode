/*
 * @lc app=leetcode.cn id=236 lang=javascript
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    
    let map = new Map();
    let queue = [];

    map.set(root, null);
    queue.push(root);

    while(!(map.has(p) && map.has(q))) {
        let node = queue.shift();
        if (node.left) {
            map.set(node.left, node);
            queue.push(node.left);
        }
        if (node.right) {
            map.set(node.right, node);
            queue.push(node.right);
        }
    }

    let set = new Set();
    while(p) {
        set.add(p)
        p = map.get(p);
    }

    while(!set.has(q)) {
        q = map.get(q);
    }

    return q;
};
// @lc code=end

