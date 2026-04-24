/*
 * @lc app=leetcode.cn id=1305 lang=java
 *
 * [1305] 两棵二叉搜索树中的所有元素
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        // 中序遍历
        inorder(root1, list1);
        inorder(root2, list2);
        
        // 合并两个有序数组
        return merge(list1, list2);
    }
    
    // 中序遍历
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    // 双指针合并
    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) {
                res.add(l1.get(i++));
            } else {
                res.add(l2.get(j++));
            }
        }
        
        // 剩余部分
        while (i < l1.size()) res.add(l1.get(i++));
        while (j < l2.size()) res.add(l2.get(j++));
        
        return res;
    }
}
// @lc code=end

