/*
 * @lc app=leetcode.cn id=894 lang=java
 *
 * [894] 所有可能的真二叉树
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

    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0)
            return new ArrayList<>();

        if (memo.containsKey(n))
            return memo.get(n);

        List<TreeNode> ans = new ArrayList<>();

        // 只有一个节点
        if (n == 1) {
            ans.add(new TreeNode(0));
            memo.put(n, ans);
            return ans;
        }

        // 左子树节点数
        for (int left = 1; left < n; left += 2) {

            int right = n - 1 - left;

            List<TreeNode> leftTrees = allPossibleFBT(left);
            List<TreeNode> rightTrees = allPossibleFBT(right);

            // 左右组合
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {

                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;

                    ans.add(root);
                }
            }
        }

        memo.put(n, ans);
        return ans;
    }
}
// @lc code=end

