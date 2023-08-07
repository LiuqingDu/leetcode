/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    // 可以用分治，把大问题分解为只有当前节点和左右子树的小问题
    // 左右子树可以继续再分解为节点和子树

    public List<TreeNode> generateTrees(int n) {
        return backtrack(1, n);
    }

    // 方法定义为生成从min到max之间的树的所有可能性
    private List<TreeNode> backtrack(int min, int max) {
        List<TreeNode> res = new LinkedList<TreeNode>();

        // 如果超出范围，返回一个空的列表
        // 注意这里至少要有一个null元素，表示有且子树为空
        // 因为如果这里连一个null元素都没有的话，下面那两层对左右子树的循环就连一轮循环都不执行
        // 导致都无法生成当前的节点，res里就是空的
        if (min > max) {
            res.add(null);
            return res;
        }

        // 给定的数值范围内，每一个数值都可以当作根节点
        for (int i = min; i <= max; i++) {
            // 根据搜索树的定义，把当前数字左边的数字拿来生成左子树
            // 右边的数字生成右子树
            // 注意方法返回的是左右子树的所有可能性，因此要两层循环
            // 将左右树的所有组合都拼在一起
            List<TreeNode> leftList = backtrack(min, i - 1);
            List<TreeNode> rightList = backtrack(i + 1, max);
            for(TreeNode leftNode: leftList) {
                for(TreeNode rightNode: rightList) {
                    TreeNode node = new TreeNode();
                    node.val = i;
                    node.left = leftNode;
                    node.right = rightNode;
                    // 把当前一种组合加入结果
                    res.add(node);
                }
            }
        }
        return res;
    }
}
// @lc code=end

