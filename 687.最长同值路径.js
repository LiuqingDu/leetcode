/*
 * @lc app=leetcode.cn id=687 lang=javascript
 *
 * [687] 最长同值路径
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
var longestUnivaluePath = function(root) {
    
    let maxPath = 0; // 全局变量，记录最长同值边数

    // 递归函数：返回以 node 为起点，向下延伸的相同节点值的最大边数
    const dfs = (node) => {
        if (node === null) return 0;

        // 1. 递归计算左右子树各自向下能延伸的最大同值边数
        let leftLen = dfs(node.left);
        let rightLen = dfs(node.right);

        let arrowLeft = 0;
        let arrowRight = 0;

        // 2. 如果左子节点存在，且值与当前节点相同，说明左边可以连通
        if (node.left !== null && node.left.val === node.val) {
            arrowLeft = leftLen + 1;
        }

        // 3. 如果右子节点存在，且值与当前节点相同，说明右边可以连通
        if (node.right !== null && node.right.val === node.val) {
            arrowRight = rightLen + 1;
        }

        // 4. 以当前节点为“转折点”的同值路径长度 = 左边同值边数 + 右边同值边数
        // 用这个长度去更新全局最大值
        maxPath = Math.max(maxPath, arrowLeft + arrowRight);

        // 5. 向上汇报：对于父节点来说，只能选择左或右其中的一条单侧路径，所以返回较大者
        return Math.max(arrowLeft, arrowRight);
    };

    dfs(root);
    return maxPath;
};
// @lc code=end

