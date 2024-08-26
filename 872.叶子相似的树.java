/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
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
    // 把所有叶子节点找出来依次对比
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = traversal(root1);
        List<Integer> list2 = traversal(root2);
        
        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        
        return true;
    }

    private List<Integer> traversal(TreeNode node) {
        // 先从左侧遍历，没有左子节点了再访问一次右节点，deque记录访问过的节点
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        while (node != null || !queue.isEmpty()) {
            // 先从左侧访问
            while (node != null) {
                queue.addLast(node);
                node = node.left;
            }

            // 没有左孩子了，就取出最后一个节点
            node = queue.pollLast();

            // 如果没有右节点则加入列表
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }

            // 访问一个右节点，然后下轮循环继续访问它的左节点
            node = node.right;
        }
        return list;
    }
}
// @lc code=end

