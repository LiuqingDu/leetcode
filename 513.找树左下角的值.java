/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
    public int findBottomLeftValue(TreeNode root) {
        // 宽度优先,一层一层遍历,记录当前层的第一个元素

        // 使用队列来进行层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int bottomLeftValue = root.val; // 初始化为根节点的值

        while (!queue.isEmpty()) {
            int size = queue.size(); // 当前层的节点数

            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                // 如果是当前层的第一个节点，更新 bottomLeftValue
                if (i == 0) {
                    bottomLeftValue = current.val;
                }

                // 将子节点加入队列（先左后右）
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return bottomLeftValue; // 返回最后记录的值
    }
}
// @lc code=end

