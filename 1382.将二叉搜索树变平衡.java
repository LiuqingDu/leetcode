/*
 * @lc app=leetcode.cn id=1382 lang=java
 *
 * [1382] 将二叉搜索树变平衡
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
    // 用于存储中序遍历结果的动态数组
    private List<TreeNode> nums = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        // 第一步：中序遍历，把二叉树里的节点按顺序“拍平”存入数组
        inOrder(root);
        
        // 第二步：利用二分法，从有序数组重建平衡二叉树
        return buildTree(0, nums.size() - 1);
    }

    // 中序遍历：左 -> 根 -> 右
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        nums.add(node); // 把节点加入数组（注意：加入节点本身，或者只加值都可以，这里加节点方便后续直接用）
        inOrder(node.right);
    }

    // 分治法建树：每次挑选中间节点作为根
    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        
        // 找到当前区间的中间位置
        int mid = left + (right - left) / 2;
        
        // 抽出中间节点作为当前的根节点
        TreeNode root = nums.get(mid);
        
        // 【关键点】清空原有的左右指针，避免旧树的连接干扰新树
        root.left = buildTree(left, mid - 1);   // 左边那一半去建左子树
        root.right = buildTree(mid + 1, right); // 右边那一半去建右子树
        
        return root;
    }
}
// @lc code=end

