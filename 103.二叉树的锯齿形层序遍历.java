/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        boolean flag = true;

        queue.push(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> line = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.removeFirst();
                line.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            if (!flag) {
                Collections.reverse(line);
            }
            res.add(line);
            flag = !flag;
        }

        return res;
    }
}
// @lc code=end

