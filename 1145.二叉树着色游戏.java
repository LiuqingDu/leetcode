/*
 * @lc app=leetcode.cn id=1145 lang=java
 *
 * [1145] 二叉树着色游戏
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
    // 可以看出, 实际上是在玩家一选择第一个点后,所有节点就被分为三部分
    // 该节点的左子树,右子树,父节点之外的树
    // 题目的意思是,玩家二在这三个区域里,需要有一个区域的节点数大于一半
    // 总节点数为奇数,所以必定会分出胜负,那么玩家二舅需要大于一半
    // 如果存在这个区域,那么玩家二选择这个区域跟该节点相邻的那个节点作为玩家二的起点即可

    TreeNode xNode;
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        find(root, x);
        int leftSize = getSubtreeSize(xNode.left);
        if (leftSize >= (n + 1) / 2) {
            return true;
        }
        int rightSize = getSubtreeSize(xNode.right);
        if (rightSize >= (n + 1) / 2) {
            return true;
        }
        int remain = n - 1 - leftSize - rightSize;
        return remain >= (n + 1) / 2;
    }

    public void find(TreeNode node, int x) {
        if (xNode != null || node == null) {
            return;
        }
        if (node.val == x) {
            xNode = node;
            return;
        }
        find(node.left, x);
        find(node.right, x);
    }

    public int getSubtreeSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSubtreeSize(node.left) + getSubtreeSize(node.right);
    }
}
// @lc code=end

