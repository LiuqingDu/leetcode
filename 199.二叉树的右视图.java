/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();

        if (root == null) {
            return res;
        }

        // 一行一行遍历树，需要用队列，每次从队列头读取节点，
        // 把当前节点的子节点放到队列末尾
        // 读取前先计算队列长度，可以控制按行分批次读取节点
        // 每行最右边的节点就是结果
        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            res.add(queue.peek().val);
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return res;
    }
}
// @lc code=end

