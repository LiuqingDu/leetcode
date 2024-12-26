/*
 * @lc app=leetcode.cn id=623 lang=java
 *
 * [623] 在二叉树中增加一行
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // bfs
        
        // 如果 depth == 1，直接创建一个新根节点
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        // 使用队列进行 BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;
        
        // 遍历到 depth - 1 层
        while (!queue.isEmpty() && currentDepth < depth - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            currentDepth++;
        }
        
        // 插入新的一行
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            
            // 把当前节点的子树挂在新节点上
            newLeft.left = currentNode.left;
            newRight.right = currentNode.right;
            
            // 把新节点挂在当前节点上
            currentNode.left = newLeft;
            currentNode.right = newRight;
        }
        
        return root;
    }
}
// @lc code=end

