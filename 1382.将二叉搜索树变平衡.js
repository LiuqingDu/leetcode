/*
 * @lc app=leetcode.cn id=1382 lang=javascript
 *
 * [1382] 将二叉搜索树变平衡
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
 * @return {TreeNode}
 */
var balanceBST = function(root) {
    
    const nums = [];

    // 第一步：中序遍历（左 -> 根 -> 右），将二叉搜索树转化为有序数组
    function inOrder(node) {
        if (!node) return;
        inOrder(node.left);
        nums.push(node); // 这里直接存节点对象，方便后面重组
        inOrder(node.right);
    }

    // 第二步：分治法，每次取中间节点作为根，递归构建平衡二叉树
    function buildTree(left, right) {
        if (left > right) return null;

        // 取中间位置
        const mid = Math.floor(left + (right - left) / 2);
        const rootNode = nums[mid];

        // 核心：斩断原有的左右指针连接，重新赋上平衡后的左右子树
        rootNode.left = buildTree(left, mid - 1);
        rootNode.right = buildTree(mid + 1, right);

        return rootNode;
    }

    // 执行流程
    inOrder(root);
    return buildTree(0, nums.length - 1);
};
// @lc code=end

