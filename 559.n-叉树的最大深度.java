/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        // 计算子树的最大高度
        for (Node node: root.children) {
            res = Math.max(res, maxDepth(node));
        }
        // 子树最大高度加上当前的一层
        return res + 1;
    }
}
// @lc code=end

