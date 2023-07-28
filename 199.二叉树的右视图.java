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


    // DFS 按照中-右-左的顺序，深度从0开始计算
    // 当深度等于res.size的时候说明当前层的最右节点还没有出现，当前节点就是最右节点

    // List<Integer> res = new ArrayList<>();

    // public List<Integer> rightSideView(TreeNode root) {
    //     dfs(root, 0); // 从根节点开始访问，根节点深度是0
    //     return res;
    // }

    // private void dfs(TreeNode root, int depth) {
    //     if (root == null) {
    //         return;
    //     }
    //     // 先访问 当前节点，再递归地访问 右子树 和 左子树。
    //     if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
    //         res.add(root.val);
    //     }
    //     depth++;
    //     dfs(root.right, depth);
    //     dfs(root.left, depth);
    // }
}
// @lc code=end

