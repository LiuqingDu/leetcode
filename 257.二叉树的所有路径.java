/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        dfs(root, path, res);
        return res;

    }
    
    private void dfs(TreeNode node, LinkedList<Integer> path, ArrayList<String> res) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {
            res.add(path.stream().map(Object::toString).collect(Collectors.joining("->")));
        } else {
            dfs(node.left, path, res);
            dfs(node.right, path, res);
        }
        path.removeLast();
    }
}
// @lc code=end

