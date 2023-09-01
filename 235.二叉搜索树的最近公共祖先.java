/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // 如果两个数一个比root小一个比root大，也就是这两个数分别在左右子树上，那么root就是最近公共祖先
    // 如果两个数在同一侧的子树上，那么公共祖先就在这颗树上
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 用root分别减去p和q，这两个差值相乘，结果如果为正数，说明两个差值要么都是正要么都是负，也就是pq在同一侧
        // 注意int相乘有可能会超出int范围，因此要转换为long
        if ((long) (root.val - p.val) * (root.val - q.val) > 0) {
            if (root.val > p.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }
        } else {
            // 如果乘积为负数，说明差值一正一负，说明p和q分别在两侧，那么root就是最近公共祖先
            return root;
        }
    }
}
// @lc code=end

