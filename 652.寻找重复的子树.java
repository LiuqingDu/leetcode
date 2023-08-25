/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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

    // 其实就是遍历一下整个树，在后序遍历之后就已经遍历了当前节点下的所有节点
    // 也就可以记录一下这些节点，按照固定的顺序记录的话，就可以分辨出来每一棵树是不是相同了

    // 记录每棵树的样子
    Map<String, Integer> memo = new HashMap<String, Integer>();
    // 存储相同的树的根节点
    List<TreeNode> res = new LinkedList<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        travesal(root);
        return res;
    }

    // 后序遍历，返回当前节点的树的样子
    private String travesal(TreeNode node) {
        // 空节点直接返回
        if (node == null) {
            return "!";
        }

        // 后序遍历，就可以获得完整的树的样子，先获得左右子树的样子
        String left = travesal(node.left);
        String right = travesal(node.right);

        String str = left + "," + right + "," + node.val;

        // 查找当前这棵树是否已经出现过
        int i = memo.getOrDefault(str, 0);
        // 出现过则加到结果中,且因为==1所以只会在第一次重复的时候添加
        if (i == 1) {
            res.add(node);
        }
        // 更新当前树出现的次数
        memo.put(str, i + 1);

        // 返回当前树的样子
        return str;
    }
}
// @lc code=end

