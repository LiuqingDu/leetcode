/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N 叉树的前序遍历
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
    private List<Integer> res = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        pre(root);
        return res;
    }

    private void pre(Node node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        for (Node n: node.children) {
            pre(n);
        }
    }
}
// @lc code=end

