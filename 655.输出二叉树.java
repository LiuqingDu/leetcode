/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] 输出二叉树
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
    public List<List<String>> printTree(TreeNode root) {
        // 深度优先
        // 先计算深度,然后初始化一个数组
        // 再把每个节点填充到数组里

        // 深度, 根节点的深度是 1
        int height = calDepth(root);
        // 初始化二维列表，m 是行数，n 是列数
        int m = height;
        int n = (1 << height) - 1;

        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<String>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }
            res.add(row);
        }
        // 最后一个参数是下面还有多少层
        dfs(res, root, 0, (n - 1) / 2, height - 1);
        return res;
    }

    // 计算二叉树的深度
    private int calDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(calDepth(root.left), calDepth(root.right));
    }

    // 深度优先搜索填充二维列表
    private void dfs(List<List<String>> res, TreeNode root, int row, int col, int remainingDepth) {
        if (root == null) {
            return;
        }

        // 填充当前节点值
        res.get(row).set(col, Integer.toString(root.val));

        // 计算左右子树的位置偏移
        // 如果下面只有一层, 就是只偏移 1 位, 那么位计算移动的位数为 0
        int offset = 1 << (remainingDepth - 1);

        // 递归左子树
        if (root.left != null) {
            dfs(res, root.left, row + 1, col - offset, remainingDepth - 1);
        }

        // 递归右子树
        if (root.right != null) {
            dfs(res, root.right, row + 1, col + offset, remainingDepth - 1);
        }
    }
}
// @lc code=end

