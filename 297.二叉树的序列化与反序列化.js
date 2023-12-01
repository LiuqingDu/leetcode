/*
 * @lc app=leetcode.cn id=297 lang=javascript
 *
 * [297] 二叉树的序列化与反序列化
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
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    let ser = function(node) {
        let res = "";
        if (!node) {
            res+="#,";
            return res;
        }

        res+=node.val + ",";
        res+=ser(node.left);
        res+=ser(node.right);

        return res;
    }

    return ser(root);
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    let deser = function(nodes) {
        if (!nodes.length) {
            return null;
        }

        let node = new TreeNode();
        node.val = nodes.shift();

        if (node.val === "#") {
            return null;
        }

        node.left = deser(nodes);
        node.right = deser(nodes);

        return node;
    }

    let list = data.split(",");
    return deser(list);
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
// @lc code=end

