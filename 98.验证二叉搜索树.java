/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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

    // 注意一个节点的左边所有节点均必须小于当前节点，不仅仅是左节点这一个
    // 本方法依次传入当前节点及所有子节点的上下界
    // 上下界没有用MIN_VALUE和MAX_VALUE是因为有的测试用例的根节点就是这个极值，会导致判定错误
    // 另一个方法是中序遍历，中序遍历的结果是依次递增的，否则就不合规

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        // 注意这里如果等于也是 false
        if (min!=null && node.val<=min) {
            return false;
        }
        // 注意这里如果等于也是 false
        if (max!=null && node.val>=max) {
            return false;
        }
        // 要求左子树的最大值要比当前节点小
        // 右子树的最小值要比当前节点大
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
// @lc code=end

