/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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

    // 这道题类似105，关键在于找到根节点，左子树节点、右子树节点在两个遍历里具体的索引位置
    // 找到它们的起始和结束的索引位置是核心
    Map<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[]postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int index = valToIndex.get(rootVal);

        int leftSize = index - inStart;

        // 注意后续遍历的左侧元素是左树，共有leftSize个，起点是postStart, 那么postStart+leftSize就等于右子树的第一个元素
        // 那么左子树的最后一个元素就是postStart+leftSize-1, 需要减去1才行
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        // 另外，postEnd这个位置是根节点，所以最后一个右子树元素是postEnd-1
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
// @lc code=end

