/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root== null) {
            return null;
        }
        // 按一行一行的顺序遍历二叉树，需要用到队列，每次从队列头开始将节点依次取出
        // 然后将节点的子节点放到队列末尾
        // 在每次从队列头取出节点的时候，先计算一下长度，可以控制为将节点按照每层
        // 分批次遍历

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            // 标记右边的节点
            Node r = null;
            // 因为入队列是从每一行的右边先入，所以出队列也是右边先出
            for (int i = 0; i< n; i++) {
                // 从队列头取出一个（也就是从当前行的右边往左取）
                Node cur = queue.poll();
                // 当前节点的右侧指向右边的节点
                cur.next = r;
                // 右边的节点更新为当前节点
                r=cur;

                if (cur.right!=null) {
                    queue.add(cur.right);
                }
                if (cur.left!=null) {
                    queue.add(cur.left);
                }
            }
        }
        return root;
    }
}
// @lc code=end

