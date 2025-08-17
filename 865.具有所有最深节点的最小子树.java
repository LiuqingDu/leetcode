/*
 * @lc app=leetcode.cn id=865 lang=java
 *
 * [865] 具有所有最深节点的最小子树
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
    // 树的根节点的深度为 0，注意到所有深度最大的节点，都是树的叶节点。
    // 把最深的叶节点的最近公共祖先，称之为 lca 节点。
    // 递归，进行深度优先搜索，对树中的每个节点进行递归，
    // 返回当前子树的最大深度 d 和 lca 节点。
    // 如果当前节点为空，返回深度 0 和空节点。
    // 在每次搜索中，递归地搜索左子树和右子树，然后比较左右子树的深度：

    // 如果左子树更深，最深叶节点在左子树中，返回 {左子树深度 + 1，左子树的 lca 节点}
    // 如果右子树更深，最深叶节点在右子树中，返回 {右子树深度 + 1，右子树的 lca 节点}
    // 如果左右子树一样深，左右子树都有最深叶节点，返回 {左子树深度 + 1，当前节点}

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return f(root).getKey();
    }

    private Pair<TreeNode, Integer> f(TreeNode root) {
        if (root == null) {
            return new Pair<>(root, 0);
        }

        Pair<TreeNode, Integer> left = f(root.left);
        Pair<TreeNode, Integer> right = f(root.right);

        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            return new Pair<>(right.getKey(), right.getValue() + 1);
        }
        return new Pair<>(root, left.getValue() + 1);
    }
}
// @lc code=end

