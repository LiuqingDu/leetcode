/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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

    // 前序遍历的第一个元素是根节点
    // 中序遍历中，先找到根节点在哪里，然后左侧就是左子树的节点，右侧就是右子树节点，
    // 可以根据中序遍历算出左右子树节点数量
    // 前序遍历从第二个元素开始，先是所有左子树节点，然后是所有右子树节点，
    // 根据左子树节点数量，可以在前序遍历中分割出左右子树元素串，那么这两个串的第一个元素又是根节点了
    // 以此类推每次构建子树根节点

    // map存储中序遍历中，每个节点和对应的索引，
    // 本来用for循环去找指定节点在中序遍历中的索引也是可以的，但效率比较低
    // 题目说了节点值不重复，则可以建立map用来快速查找
    private Map<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // 表示当前树是preorder[preStart, preEnd]和inorder[inStart, inEnd]这些元素组成的
    // 这两个区间的遍历是相同的，对应的一颗子树
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // 前序遍历第一个就是根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 查找根节点在中序遍历的索引
        int index = valToIndex.get(rootVal);
        // 计算出左子树有多少个节点
        // 中序遍历的左侧就是左子树的节点，注意左子树节点是从inStart开始的
        int leftSize = index - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);

        return root;
    }
}
// @lc code=end

