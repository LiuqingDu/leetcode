/*
 * @lc app=leetcode.cn id=988 lang=javascript
 *
 * [988] 从叶结点开始的最小字符串
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
 * @return {string}
 */
var smallestFromLeaf = function(root) {
    let res = "";
    const dfs = (node, str) => {
        if (!node) {
            return;
        }

        str.push(String.fromCharCode(97 + node.val))

        if (!node.left && !node.right) {
            const s = [...str].reverse().join("");

            if (res === "") {
                res = s;
            } else if (s.localeCompare(res) < 0) {
                res = s;
            }
        }

        dfs(node.left, str);
        dfs(node.right, str);
        str.pop();
    }

    dfs(root, []);
    return res;
};
// @lc code=end

