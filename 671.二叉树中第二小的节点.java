/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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
    public int findSecondMinimumValue(TreeNode root) {
        // 已知根节点等于min(left, right)
        // 那么两个子节点至少有一个节点等于根节点，
        // 记相等的那个子节点为A，
        // 对于那个不相等的子节点，也就是大于根节点的，记为B节点，这一侧的子树上，B是最小值
        // 这个B有可能是根节点后第二大的值，但也可能不是，不过B的下面就不可能有第二大了，它们都会比B大
        // 那么看A这一侧，是有可能出现一个比根节点大，但又小于B的节点，
        // 如果存在，那么这个节点就会顶替B成为第二大节点
        // 如果不存在，那么B就是第二大节点
        // 因此，我们可以递归

        // 定义方法为找到以给定节点为根的第二大节点
        // 首先看两个子树中，哪个子节点A等于根节点，哪个子节点B大于根节点
        // 先记下B，然后递归A去找这一侧的第二大，因为A等于根节点，所以A的第二大就可能是根的第二大
        // 除非B可以顶替A的第二大成为根的第二大

        // 如果当前节点为空，或者没有子节点（因为如果有子节点则两个节点都存在，所以可以只判断一个）
        // 那么就不会存在第二大节点，返回-1
        if (root == null || root.left == null) {
            return -1;
        }
        // 记录左右两棵树各自认为的第二大节点
        // 其中对于不等于（也就是大于）根节点的子节点来说，这个子节点就认为它自己是第二大
        // 对于等于根节点的那一层，它需要递归再去寻找它自己选出来的第二大
        int left = root.val == root.left.val ? 
                    findSecondMinimumValue(root.left) :
                    root.left.val;
        int right = root.val == root.right.val ?
                    findSecondMinimumValue(root.right) :
                    root.right.val;
        int min = Math.min(left, right);
        // 根据各自选择的第二大，找出更小的那一个当作新的第二大
        // 因为节点值最小为1，也就是不为0，那么结果有两种可能，
        // 要么大于0，说明两侧都选出来了第二大，此时min就是最终的第二大
        // 要么等于-1，说明至少有一侧没有选出第二大，那么另外一个（也就是两侧更大的那个候选者）就是第二大
        // 即使两侧都没有选出，都是-1也不影响
        return min > 0 ? min : Math.max(left, right);
    }
}
// @lc code=end

