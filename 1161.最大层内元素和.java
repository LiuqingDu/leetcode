/*
 * @lc app=leetcode.cn id=1161 lang=java
 *
 * [1161] 最大层内元素和
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
    // DFS
    
    private List<Integer> sum = new ArrayList<Integer>();

    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        int ans = 0;
        for (int i = 0; i < sum.size(); ++i) {
            if (sum.get(i) > sum.get(ans)) {
                ans = i;
            }
        }
        return ans + 1; // 层号从 1 开始
    }

    private void dfs(TreeNode node, int level) {
        if (level == sum.size()) {
            sum.add(node.val);
        } else {
            sum.set(level, sum.get(level) + node.val);
        }
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }
    }
}
// @lc code=end

