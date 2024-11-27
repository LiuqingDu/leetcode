/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和
        // 记录从根节点到每一个节点的路径上的和,如果在当前节点之前存在一个和presum
        // 使得当前的前缀和 currentSum = target + presum

        // 使用哈希表记录前缀和的频率
        // 这里用 long 因为有前缀和超出了 int
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();
        // 初始化：前缀和为 0 的路径出现 1 次
        prefixSumMap.put(0l, 1);

        // 开始递归
        return dfs(root, 0, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }

        // 当前路径的前缀和
        currentSum += node.val;

        // 计算路径数：当前前缀和 - 目标值 = 之前某个前缀和
        // 这里是找上面分析的 presum
        int pathCount = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        // 更新前缀和频率
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        // 递归处理左右子树
        pathCount += dfs(node.left, currentSum, targetSum, prefixSumMap);
        pathCount += dfs(node.right, currentSum, targetSum, prefixSumMap);

        // 回溯：撤销当前节点的前缀和，防止影响其他分支
        // 因为这里表示当前节点下的所有节点都已经分析过了,要去隔壁分支了,那么当前节点就不能在考虑范围内了
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return pathCount;
    }
}
// @lc code=end

