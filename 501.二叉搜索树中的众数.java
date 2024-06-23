/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */

// @lc code=start

import java.util.List;

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
    // 二叉搜索树的中序遍历就是把所有数字从小到大排序
    // 记录数字出现的最大次数，遍历的时候统计当前数字的次数，
    // 如果等于最大次数，就把这个数字放到结果中
    // 如果大于最大次数，那么之前已经放进去的数字都不是最大次数了，需要清空掉
    // 然后把当前数字放进去，并更新最大次数
    // 记录一个数字出现的次数，需要跟上一个数字比较，可以单独记录一下上一个访问的数字
    List<Integer> res = new ArrayList<Integer>();
    TreeNode pre = null;
    int curCount = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        // 中序遍历
        inOrder(node.left);

        // 跟上一个数字比较，相同则次数+1
        if (pre != null && pre.val == node.val) {
            curCount++;
        } else {
            // 不相同，或者pre==null现在是第一个数字，计数重置为1
            curCount = 1;
        }
        // 如果当前次数更大，则清空结果并记录当前的
        if (curCount > maxCount) {
            res.clear();
            res.add(node.val);
            maxCount = curCount;
        } else if (curCount == maxCount) {
            res.add(node.val);
        }

        // 更新pre上一个数为当前这个数字
        pre = node;
        // 中序遍历最后访问右节点
        inOrder(node.right);
    }
}
// @lc code=end

