/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 根据满二叉树的节点编号规则：若根节点编号为 u，则其左子节点编号为 u << 1，其右节点编号为 u << 1 | 1。
    // 一个朴素的想法是：我们在 DFS过程中使用两个哈希表分别记录每层深度中的最小节点编号和最大节点编号，两者距离即是当前层的宽度，最终所有层数中的最大宽度即是答案。
    // 而实现上，我们可以利用先 DFS 左节点，再 DFS 右节点的性质可知，每层的最左节点必然是最先被遍历到，因此我们只需要记录当前层最先被遍历到点编号（即当前层最小节点编号），并在 DFS 过程中计算宽度，更新答案即可。

    Map<Integer, Integer> map = new HashMap<>();
    int res;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0);
        return res;
    }

    void dfs(TreeNode root, int u, int depth) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(depth)) {
            map.put(depth, u);
        }
        res = Math.max(res, u - map.get(depth) + 1);
        u = u - map.get(depth) + 1;
        dfs(root.left, u * 2, depth + 1);
        dfs(root.right, u * 2 + 1, depth + 1);
    }
}
// @lc code=end

