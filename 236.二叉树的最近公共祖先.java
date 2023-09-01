/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 查找最近的公共祖先，需要先找到公共祖先，然后找最近的那一个
    // 可以先把p的所有祖先找出来，然后再依次把q的祖先拿出来挨个跟p的祖先对比，直到有一个相同为止
    // 使用BFS广度优先搜索，并记录每一个节点和它对应的父节点，搜索到p和q都找到为止，这样可以提前结束搜索，
    // 凡是比p和q还深的节点都可以不用搜索了
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // 记录每个节点和它的父节点
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        // 先把root放进去
        map.put(root, null);
        queue.add(root);

        // BFS
        // 因为保证p和q在树里面，所以这里条件不用判断queue.size()!=0
        // 直到map里同时存在p和q的时候才退出循环
        while(!(map.containsKey(p) && map.containsKey(q))) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                map.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                queue.add(node.right);
            }
        }

        // 存放p及它的父节点
        Set<TreeNode> set = new HashSet<TreeNode>();
        while(p != null) {
            // 把p放入set，并继续找它的父节点
            set.add(p);
            p = map.get(p);
        }

        // 从q开始网上遍历它的父节点，直到它的父节点出现在set里，也就是跟p的父节点相同为止
        while(!set.contains(q)) {
            q = map.get(q);
        }

        return q;
    }
}
// @lc code=end

