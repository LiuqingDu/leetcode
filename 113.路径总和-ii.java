/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        backtrack(root, new ArrayList<Integer>(), 0, targetSum);

        return res;
    }

    private void backtrack(TreeNode node, ArrayList<Integer> path, int sum, int targetSum) {

        if (node == null) {
            return;
        }

        path.add(node.val);
        sum += node.val;

        if (sum == targetSum && node.left == null && node.right == null) {
            res.add(new ArrayList<Integer>(path));
        }

        backtrack(node.left, path, sum, targetSum);
        backtrack(node.right, path, sum, targetSum);

        sum -= node.val;
        path.remove(path.size() - 1);
    }
}
// @lc code=end

