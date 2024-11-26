/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
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
    // dfs 从底部计算,存到map里
    
    private Map<Integer, Integer> sumCount; // 记录子树和及其出现次数
    private int maxFreq; // 记录最高频率

    public int[] findFrequentTreeSum(TreeNode root) {
        sumCount = new HashMap<>();
        maxFreq = 0;

        // 计算所有子树的和
        dfs(root);

        // 收集出现频率最高的子树和
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumCount.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }

        // 转换为数组返回
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // 计算左子树和右子树的和
        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        // 当前子树和
        int currentSum = node.val + leftSum + rightSum;

        // 更新子树和的频率
        sumCount.put(currentSum, sumCount.getOrDefault(currentSum, 0) + 1);

        // 更新最高频率
        maxFreq = Math.max(maxFreq, sumCount.get(currentSum));

        return currentSum;
    }
}
// @lc code=end

