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


        // 后面会取到索引为preStart+1，但有一种极端可能是所有节点都满足在左节点
        // 导致preStart一直向右逼近preEnd，但preEnd又不往左移动，最终preStart和preEnd在最右边相遇
        // 那么这时候preStart+1就超出索引了，所以这里提前返回一个单独节点
        if (preStart == preEnd) {
            // System.out.println(""+preStart+preEnd+postStart+postEnd);
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

