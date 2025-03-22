/*
 * @lc app=leetcode.cn id=1379 lang=java
 *
 * [1379] 找出克隆二叉树中的相同节点
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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // dfs
        // 在两棵树上同步操作,原树上找到原节点,则克隆树上也找到了对应节点

        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }

        // 同步先找左子树
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }
        // 再找右子树
        return getTargetCopy(original.right, cloned.right, target);

    }
}
// @lc code=end

