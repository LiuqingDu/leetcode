/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    Map<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);

    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // 当preStart == preEnd时，说明再也没有子树了，因为[preStart, preEnd]之间的节点就是一棵树
        // 提前返回叶子节点，否则后面的逻辑会把其他节点当作子节点
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int leftVal = preorder[preStart + 1];
        int index = valToIndex.get(leftVal);
        int leftSize = index - postStart + 1;

        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);

        return root;

    }
}
// @lc code=end

