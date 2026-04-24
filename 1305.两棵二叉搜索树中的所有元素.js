/*
 * @lc app=leetcode.cn id=1305 lang=javascript
 *
 * [1305] 两棵二叉搜索树中的所有元素
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
 * @return {number[]}
 */
var getAllElements = function(root1, root2) {
    const list1 = [];
    const list2 = [];

    // 中序遍历
    const inorder = (root, list) => {
        if (!root) return;
        inorder(root.left, list);
        list.push(root.val);
        inorder(root.right, list);
    };

    inorder(root1, list1);
    inorder(root2, list2);

    // 合并两个有序数组
    let i = 0, j = 0;
    const res = [];

    while (i < list1.length && j < list2.length) {
        if (list1[i] < list2[j]) {
            res.push(list1[i++]);
        } else {
            res.push(list2[j++]);
        }
    }

    // 处理剩余元素
    while (i < list1.length) res.push(list1[i++]);
    while (j < list2.length) res.push(list2[j++]);

    return res;
};
// @lc code=end

